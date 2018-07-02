package myThreadPool;

public class MyExecutor implements Runnable{
	String msg;
	MyExecutor(String msg){
		this.msg = msg;
	}
	
	
	@Override
	public void run() {
		System.out.println("myExecutor run " + msg + "\t" + Thread.currentThread().getId());
		System.out.println("MyExecutor sleep start " + msg + "\t" + Thread.currentThread().getId());
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MyExecutor sleep end " + msg + "\t" + Thread.currentThread().getId());
	}
	
}
