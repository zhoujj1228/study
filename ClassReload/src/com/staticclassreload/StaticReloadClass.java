package com.staticclassreload;

/**
 * ���Ծ�̬�����Ƿ��ܱ��ȼ���
 * @author Jay
 * @date 2018��3��20��
 */
public class StaticReloadClass {
	/**
	 * ͻ��ClassLoader.loadClass()��Class.forName()������
	 * ClassLoader.loadClass()Ĭ�ϲ���ʼ������̬���뾲̬���󲻻�ִ��
	 * Class.forName()Ĭ�ϳ�ʼ������̬���뾲̬�����ִ��
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
