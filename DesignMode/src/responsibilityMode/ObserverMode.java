package responsibilityMode;
import java. util. Observable;
import java.util.Observer;

/**
 * 观察者模式是对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * 适用场景：当一个类和另一个类有依赖关系，根据另一个类的变化而做相应处理，这时候可以使用观察者模式
 * @author Jay
 * @date 2017年5月2日
 */
public class ObserverMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Earth earth = new Earth();
		earth.addObserver(new Fisherman());
		earth.addObserver(new Satellite());
		earth.setWeather("暴雨");
		earth.setWeather("阴天");
	}

}
/**
 * 被观察者
 * @author Jay
 * @date 2017年5月2日
 */
class Earth extends Observable {
	private String weather = "晴朗";

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
		setChanged();
		notifyObservers(weather);
	}
}

/**
 * 观察者，气象卫星
 * @author Jay
 * @date 2017年5月2日
 */
class Satellite implements Observer {
	private String weather;

	public void update(Observable obj, Object arg) {
		weather = (String) arg;
		System.out.println("近期 天气 变化：" + weather);
	}
}

/**
 * 观察者，渔民
 * @author Jay
 * @date 2017年5月2日
 */
class Fisherman implements Observer{
	String weather;
	String position;
	public void update(Observable o, Object arg) {
		weather = (String) arg;
		if(weather.equals("暴雨")){
			System.out.println("暴雨來了，返航");
		}
	}
	
}

