package singleton;

/**
 * 1.既是一种类(class)类型却又比类类型多了些特殊的约束，但是这些约束的存在也造就了枚举类型的简洁性、安全性以及便捷性
 * 2.构造方法只能被编译器调用
 * 
 * 实际上在使用关键字enum创建枚举类型并编译后，编译器会为我们生成一个相关的类，这个类继承了Java API中的java.lang.Enum类
 * @author Jay
 * @date 2018年7月12日
 */
public enum MySingleton {
	INSTANCE;
	int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
