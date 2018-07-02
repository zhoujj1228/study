package myCountdownLatch;

public class TestMyCDL {

	public static void main(String[] args) throws InterruptedException {
		new TestMyCDL().call();
	}

	private void call() throws InterruptedException {
		MyCountDownLatch mcdl = new MyCountDownLatch(3);
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t1 start");
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1 end");
				mcdl.countDown();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t2 start");
				try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2 end");
				mcdl.countDown();
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t3 start");
				try {
					Thread.currentThread().sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t3 end");
				mcdl.countDown();
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("t4 wait");
				try {
					mcdl.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t4 end");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		System.out.println("main wait");
		mcdl.await();
		System.out.println("main end");
		
		
	}

}
