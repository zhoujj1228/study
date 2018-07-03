package interfaceMode;

/**
 * ͻ����ʾ�ӿںͳ���������𡣳�������is-a�ĸ���ӿ���like-a����ᱨ�����ţ����ǳ����࣬���������ǽӿڡ�
 * @author Jay
 * 
 */
public class InterfaceAndAbClass {

}

abstract class Door {
	abstract void open();

	abstract void close();
}

interface Alarm {
	void alarm();
}

class AlarmDoor extends Door implements Alarm {
	void open() {
	}

	void close() {
	}

	public void alarm() {
	}
}
