package singleton;


public class MySingletonExample {

	public static void main(String[] args) {
		new MySingletonExample().call();
	}

	private void call() {
		MySingleton ms = MySingleton.INSTANCE;
		int value = ms.getValue();
		System.out.println(value);
		ms.setValue(9);
		
		MySingleton ms1 = MySingleton.INSTANCE;
		int value1 = ms1.getValue();
		System.out.println(value1);
		
	}

}
