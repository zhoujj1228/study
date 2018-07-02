package com.noexistclassreload;

import java.util.Scanner;

/**
 * 主要测试后来添加的类能否被加载
 * Class.forName("com.noexistclassreload.AfterReloadClass"):会使用当前类的定义类加载器进行加载新的类
 * 
 * @author Jay
 * @date 2018年5月7日
 */
public class Test {
	String isBefore = "0";
	IReloadClass irc;
	public static void main(String[] args) {
		new Test().call();
	}

	private void call() {
		while(true){
			System.out.println("input Flag:");
			isBefore = new Scanner(System.in).nextLine();
			if(isBefore.equals("0")){
				irc = new BeforeReloadClass();
			}else{
				ClassLoader cl = ClassLoader.getSystemClassLoader();
				System.out.println(cl);
				Class<IReloadClass> afClass = null;
				try {
//					afClass = (Class<IReloadClass>) cl.loadClass("com.noexistclassreload.AfterReloadClass");
					afClass = (Class<IReloadClass>) Class.forName("com.noexistclassreload.AfterReloadClass");
					irc = afClass.newInstance();
				} catch (Exception e) {
					irc = new BeforeReloadClass();
					e.printStackTrace();
				}
			}
			irc.test();
			
		}
	}

}
