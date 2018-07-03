package responsibilityMode;

/**
 * ����ģʽ
 * @author Jay
 * @date 2017��4��28��
 */
public class SingletonMode {
	private static SingletonMode singleton = null;
	public static Object synObj = new Object();
	
	public static SingletonMode getInstance() {
		if (singleton == null) {
			synchronized(synObj){
				if(singleton == null){
					singleton = new SingletonMode();	
				}
			}
		}
		return singleton;
	}
}


