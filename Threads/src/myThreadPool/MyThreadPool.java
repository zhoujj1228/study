package myThreadPool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * �ؼ�:
 * 1.����Thread������
 * 2.��������Ķ���
 * 3.ִ������Ĵ���
 * 4.����������߳�
 * 
 * ʹ��һ��Map����ִ���̺߳�����ִ�д����ӳ���ϵ
 * ʹ��countDownLatchʵ������ִ���������
 * @author Jay
 * @date 2018��5��7��
 */
public class MyThreadPool {
	
	public static void main(String[] args) throws InterruptedException{
		MyThreadPool mtp = new MyThreadPool(2, 50);
		for(int i = 0; i < 100; i++){
			MyExecutor me = new MyExecutor("me" + i);
			boolean status = mtp.execute(me);
			System.out.println("me" + i + "---" +status);
		}

		
	}
	LinkedBlockingQueue<Thread> pool;
	Runnable executor;
	LinkedBlockingQueue<Runnable> tempQueue;
	HashMap<Long, ExecutorProxy> tidTaskMap = new HashMap<Long, ExecutorProxy>(10);
	int poolSize;
	int queueSize;
	MyThreadPool(int poolSize, int queueSize){
		this.poolSize = poolSize;
		this.queueSize = queueSize;
		pool = new LinkedBlockingQueue<Thread>(poolSize);
		for(int i = 0; i < poolSize; i++){
			ExecutorProxy ep = new ExecutorProxy();
			Thread t = new Thread(ep);
			ep.setExecuteThread(t);
			t.start();
			tidTaskMap.put(t.getId(), ep);
			pool.add(t);
		}
		tempQueue = new LinkedBlockingQueue<Runnable>(queueSize);
		QueueListener ql = new QueueListener();
		Thread listener = new Thread(ql);
		listener.start();
	}
	
	public boolean execute(Runnable realExecutor){
		try {
			return tempQueue.add(realExecutor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	class QueueListener implements Runnable{
		boolean isRun = true;
		
		public void stop(){
			isRun = false;
		}
		@Override
		public void run() {
			while(isRun){
				System.out.println("QueueListener listen tempQueue.size() = " + tempQueue.size());
				Thread exThread = null;
				try {
					Runnable realExecutor = tempQueue.take();
					exThread = pool.take();
					ExecutorProxy ep = tidTaskMap.get(exThread.getId());
					ep.setRealExecutor(realExecutor);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	class ExecutorProxy implements Runnable{
		public ExecutorProxy(){
		}
		Runnable realExecutor;
		//���Կ�������Ϣ��
		CountDownLatch cdl = new CountDownLatch(1);
		Thread exThread;
		public void run() {
			while(true){
				try {
					try {
						System.out.println("ExecutorProxy in wait " + Thread.currentThread().getId());
						cdl.await();
						System.out.println("ExecutorProxy out wait " + Thread.currentThread().getId());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					realExecutor.run();
				} finally {
					cdl = new CountDownLatch(1);
					pool.add(exThread);
				}
			}
		}
		
		public void setRealExecutor(Runnable realExecutor){
			this.realExecutor = realExecutor;
			cdl.countDown();
		}
		
		public void setExecuteThread(Thread t){
			exThread = t;
		}
	}
	
	
}






