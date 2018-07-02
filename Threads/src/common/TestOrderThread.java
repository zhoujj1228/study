package common;

public class TestOrderThread {
	public static void main(String[] args) throws InterruptedException {
		new TestOrderThread().call();
	}

	private void call() throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Order a = new Order(obj1, obj2, "A");
		Order b = new Order(obj2, obj3, "B");
		Order c = new Order(obj3, obj1, "C");
		Thread ta = new Thread(a);
		Thread tb = new Thread(b);
		Thread tc = new Thread(c);
		ta.start();
		tb.start();
		tc.start();
		Thread.currentThread().sleep(3000);
		synchronized (obj1) {
			obj1.notify();
		}
	}
}

class Order implements Runnable{
	Object before;
	Object after;
	String msg;
	int i = 0;
	Order(Object before, Object after, String msg){
		this.before = before;
		this.after = after;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		while(i < 10){
			synchronized (before) {
				try {
					before.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(msg);
				i++;
			}
			synchronized (after) {
				after.notify();
			}
		}
		
		
	}
	
}

