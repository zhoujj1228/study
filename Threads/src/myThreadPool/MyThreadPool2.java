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
 * 关键:
 * 1.保存Thread的容器
 * 2.保存任务的队列
 * 3.执行任务的代理
 * 4.监听任务的线程
 * 
 * 创建MyThread并新建一个属性保存执行任务代理,从而实现执行线程和执行任务代理的映射
 * 使用countDownLatch实现阻塞执行任务代理
 * @author Jay
 * @date 2018年5月7日
 */
public class MyThreadPool2 {
	
	public static void main(String[] args) throws InterruptedException{
		MyThreadPool2 mtp = new MyThreadPool2(2, 50);
		for(int i = 0; i < 100; i++){
			MyExecutor me = new MyExecutor("me" + i);
			boolean status = mtp.execute(me);
			System.out.println("me" + i + "---" +status);
		}

		
	}
	LinkedBlockingQueue<MyThread> pool;
	Runnable executor;
	LinkedBlockingQueue<Runnable> tempQueue;
	int poolSize;
	int queueSize;
	MyThreadPool2(int poolSize, int queueSize){
		this.poolSize = poolSize;
		this.queueSize = queueSize;
		pool = new LinkedBlockingQueue<MyThread>(poolSize);
		for(int i = 0; i < poolSize; i++){
			ExecutorProxy ep = new ExecutorProxy();
			MyThread t = new MyThread(ep);
			ep.setExecuteThread(t);
			t.start();
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
				MyThread exThread = null;
				try {
					Runnable realExecutor = tempQueue.take();
					exThread = pool.take();
					ExecutorProxy ep = exThread.getExecutorProxy();
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
		//可以考虑用信息量
		CountDownLatch cdl = new CountDownLatch(1);
		MyThread exThread;
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
		
		public void setExecuteThread(MyThread t){
			exThread = t;
		}
	}
	
	class MyThread extends Thread{
		Runnable target;
		
		MyThread(Runnable target){
			super(target);
			this.target = target;
		}
		
		public ExecutorProxy getExecutorProxy(){
			return (ExecutorProxy)target;
		}
	}
	
}






