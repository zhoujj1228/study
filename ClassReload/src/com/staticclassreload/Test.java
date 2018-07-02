package com.staticclassreload;

import java.lang.reflect.Method;
import java.util.Scanner;


/**
 * 突显ClassLoader.loadClass()与Class.forName()的区别
 * ClassLoader.loadClass()默认不初始化，静态块与静态对象不会执行
 * Class.forName()默认初始化，静态块与静态对象会执行
 * 即使静态块与对象当前不执行，到调用静态方法或是实例化时还是会执行
 */
public class Test {
	String isBefore = "0";
	StaticReloadClass irc;
	public static void main(String[] args) {
		new Test().call();
	}

	private void call() {
		while(true){
			System.out.println("input Flag:");
			isBefore = new Scanner(System.in).nextLine();
			if(isBefore.equals("0")){
				System.out.println("input 0");
			}else{
				ClassLoader cl = ClassLoader.getSystemClassLoader();
				Class<StaticReloadClass> afClass = null;
				try {
					afClass = (Class<StaticReloadClass>) cl.loadClass("com.staticclassreload.StaticReloadClass");
//					afClass = (Class<StaticReloadClass>) Class.forName("com.staticclassreload.StaticReloadClass");
					System.out.println("after load");
					
					/*afClass.newInstance();*/
					
					/*Method sTest = afClass.getMethod("test", null);
					sTest.invoke(null, null);*/
					
					/*Method sTest1 = afClass.getMethod("test1", null);
					sTest1.invoke(afClass.newInstance(), null);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
