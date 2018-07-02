package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.autoPack.IMediaPlayer;

/**
 * 使用组件扫描,类名MP3Player,里面自动生成的bean是MP3Player,如果类名Mp3Player,里面自动生成的bean是mp3Player
 * @author Jay
 * @date 2018年4月2日
 */

public class NoWebSpring {
	public static void main(String[] args){
		args = new String[]{"classpath:applicationContext.xml"};
		ApplicationContext actx = new ClassPathXmlApplicationContext(args);
		IMediaPlayer bean = (IMediaPlayer) actx.getBean("MP3Player");
		bean.play();
	}
}
