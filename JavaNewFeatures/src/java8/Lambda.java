package java8;

/**
 * lambda���ʽ�﷨��
 * (params) -> expression
 * (params) -> statement
 * (params) -> { statements }
 * @author Jay
 * @date 2018��7��12��
 */
public class Lambda {

	public static void main(String[] args) {
		new Lambda().test1();
	}
	
	public void test1(){
		// Java 8֮ǰ��
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		
		//Java 8��ʽ��
		new Thread( () -> { System.out.println("In Java8, Lambda expression rocks !!"); } ).start();
	}

}

