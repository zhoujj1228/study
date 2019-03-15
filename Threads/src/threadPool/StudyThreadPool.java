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
 * 其实四种threadpool的实现是同一种(是ThreadPoolExecutor)
 * 最终使用到同一个构造函数
 * public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
   }
 * 其中
 * corePoolSize 为最小线程数
 * maximumPoolSize 为最大线程数
 * keepAliveTime 为超过最小线程数的空闲线程的过期回收时间
 * unit	计算过期时间的时间单位，如秒，毫秒
 * workQueue 保存任务的队列实现
 * 后面还有两个参数通常不做处理
 *  
 * @author Jay
 * @date 2019年3月14日
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
	 * 其中可以具体查看源码,大体和CachedThreadPool一样,区别在于：
	 * 1.队列实现使用到了DelayedWorkQueue(DelayedQueue的子类，使得具备执行时间安排的效果)
	 * 2.没有过期时间
	 * @param corePoolSize
	 * @return
	 */
	public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
	/**
	 * 这个只是一部分实现，具体实现可以查看Executors.newSingleThreadExecutor()
	 */
	public static void newSingleThreadExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>());
    }
}
