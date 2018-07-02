package com.staticclassreload;

/**
 * 测试静态变量是否能被热加载
 * @author Jay
 * @date 2018年3月20日
 */
public class StaticReloadClass {
	/**
	 * 突显ClassLoader.loadClass()与Class.forName()的区别
	 * ClassLoader.loadClass()默认不初始化，静态块与静态对象不会执行
	 * Class.forName()默认初始化，静态块与静态对象会执行
	 */
	static{
		System.out.println("StaticReloadClass static run");
	}
	public static void test(){
		System.out.println("StaticReloadClass static test run");
	}
	public void test1(){
		System.out.println("StaticReloadClass test run");
	}
}
