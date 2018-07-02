package myCountdownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyCountDownLatch {
	private AtomicInteger num;
	private Object monLockObj = new Object();
	private List<Object> waitLockObjs = new ArrayList<Object>();
	
	MyCountDownLatch(int waitNum){
		if(waitNum < 0){
			return;
		}
		this.num = new AtomicInteger(waitNum);
		/*Thread monThread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(monLockObj){
					if(num.get() == 0){
						for(Object obj : waitLockObjs){
							synchronized (obj) {
								obj.notify();
							}
						}
					}
				}
			}
		});
		monThread.start();*/
	}
	
	public void await() throws InterruptedException{
		Object tempLock = new Object();
		waitLockObjs.add(tempLock);
		synchronized(tempLock){
			tempLock.wait();
		}
	}
	
	public void countDown(){
		if(num.decrementAndGet() <= 0){
			for(Object obj : waitLockObjs){
				synchronized (obj) {
					obj.notify();
				}
			}
		}
	}
}
