package myThreadPool;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SafeLinkedBlockingQueue<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int maxSize;
	LinkedBlockingQueue<E> queue;
	SafeLinkedBlockingQueue(int maxSize){
		queue = new LinkedBlockingQueue<E>(maxSize);
	}
	
	public synchronized boolean add(E e){
		return queue.add(e);
	}
	
	public synchronized E poll(){
		return queue.poll();
	}
	
	public synchronized E peek(){
		return queue.peek();
	}
	
	public synchronized int size(){
		return queue.size();
	}
}
