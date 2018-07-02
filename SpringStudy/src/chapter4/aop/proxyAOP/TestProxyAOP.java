package chapter4.aop.proxyAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.autoPack.IMediaPlayer;

/**
 * ��spring4ʹ�þ������ģʽ����AOP��Ҫ����aopalliance��
 * @author Jay
 * @date 2018��4��2��
 */

public class TestProxyAOP {

	public static void main(String[] args) {
		args = new String[]{"classpath:chapter4/aop/proxyAOP/proxy_aop_config.xml"};
		ApplicationContext actx = new ClassPathXmlApplicationContext(args);
		IMediaPlayer bean = (IMediaPlayer) actx.getBean("proxy");
		bean.play();
	}

}
