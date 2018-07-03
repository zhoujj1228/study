package interfaceMode;

/**
 * 突出显示接口和抽象类的区别。抽象类是is-a的概念，接口是like-a，如会报警的门，门是抽象类，报警功能是接口。
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
