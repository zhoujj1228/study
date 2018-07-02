package com.staticclassreload;

import java.lang.reflect.Method;
import java.util.Scanner;


/**
 * ͻ��ClassLoader.loadClass()��Class.forName()������
 * ClassLoader.loadClass()Ĭ�ϲ���ʼ������̬���뾲̬���󲻻�ִ��
 * Class.forName()Ĭ�ϳ�ʼ������̬���뾲̬�����ִ��
 * ��ʹ��̬�������ǰ��ִ�У������þ�̬��������ʵ����ʱ���ǻ�ִ��
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
