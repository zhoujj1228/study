package responsibilityMode;
import java. util. Observable;
import java.util.Observer;

/**
 * �۲���ģʽ�Ƕ�����һ��һ�Զ��������ϵ����һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�
 * ���ó�������һ�������һ������������ϵ��������һ����ı仯������Ӧ������ʱ�����ʹ�ù۲���ģʽ
 * @author Jay
 * @date 2017��5��2��
 */
public class ObserverMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Earth earth = new Earth();
		earth.addObserver(new Fisherman());
		earth.addObserver(new Satellite());
		earth.setWeather("����");
		earth.setWeather("����");
	}

}
/**
 * ���۲���
 * @author Jay
 * @date 2017��5��2��
 */
class Earth extends Observable {
	private String weather = "����";

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
 * �۲��ߣ���������
 * @author Jay
 * @date 2017��5��2��
 */
class Satellite implements Observer {
	private String weather;

	public void update(Observable obj, Object arg) {
		weather = (String) arg;
		System.out.println("���� ���� �仯��" + weather);
	}
}

/**
 * �۲��ߣ�����
 * @author Jay
 * @date 2017��5��2��
 */
class Fisherman implements Observer{
	String weather;
	String position;
	public void update(Observable o, Object arg) {
		weather = (String) arg;
		if(weather.equals("����")){
			System.out.println("������ˣ�����");
		}
	}
	
}

