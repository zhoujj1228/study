package responsibilityMode;

/**
 * 单例模式
 * @author Jay
 * @date 2017年4月28日
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


