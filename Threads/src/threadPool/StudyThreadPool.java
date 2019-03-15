package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ��ʵ����threadpool��ʵ����ͬһ��(��ThreadPoolExecutor)
 * ����ʹ�õ�ͬһ�����캯��
 * public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
   }
 * ����
 * corePoolSize Ϊ��С�߳���
 * maximumPoolSize Ϊ����߳���
 * keepAliveTime Ϊ������С�߳����Ŀ����̵߳Ĺ��ڻ���ʱ��
 * unit	�������ʱ���ʱ�䵥λ�����룬����
 * workQueue ��������Ķ���ʵ��
 * ���滹����������ͨ����������
 *  
 * @author Jay
 * @date 2019��3��14��
 */
public class StudyThreadPool {
	public static void main(String[] args) {
	}

	public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
	
	public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
	
	/**
	 * ���п��Ծ���鿴Դ��,�����CachedThreadPoolһ��,�������ڣ�
	 * 1.����ʵ��ʹ�õ���DelayedWorkQueue(DelayedQueue�����࣬ʹ�þ߱�ִ��ʱ�䰲�ŵ�Ч��)
	 * 2.û�й���ʱ��
	 * @param corePoolSize
	 * @return
	 */
	public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
	/**
	 * ���ֻ��һ����ʵ�֣�����ʵ�ֿ��Բ鿴Executors.newSingleThreadExecutor()
	 */
	public static void newSingleThreadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>());
    }
}
