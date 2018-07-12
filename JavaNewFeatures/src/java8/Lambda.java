package java8;

/**
 * lambda表达式语法：
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statements }
 * @author Jay
 * @date 2018年7月12日
 */
public class Lambda {

	public static void main(String[] args) {
		new Lambda().test1();
	}
	
	public void test1(){
		// Java 8之前：
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		
		//Java 8方式：
		new Thread( () -> { System.out.println("In Java8, Lambda expression rocks !!"); } ).start();
	}

}

