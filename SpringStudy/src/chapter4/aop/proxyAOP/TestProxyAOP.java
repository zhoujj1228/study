package chapter4.aop.proxyAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.autoPack.IMediaPlayer;

/**
 * 在spring4使用经典代理模式进行AOP需要导入aopalliance包
 * @author Jay
 * @date 2018年4月2日
 */

public class TestProxyAOP {

	public static void main(String[] args) {
		args = new String[]{"classpath:chapter4/aop/proxyAOP/proxy_aop_config.xml"};
		ApplicationContext actx = new ClassPathXmlApplicationContext(args);
		IMediaPlayer bean = (IMediaPlayer) actx.getBean("proxy");
		bean.play();
	}

}
