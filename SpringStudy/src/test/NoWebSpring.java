package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter2.autoPack.IMediaPlayer;

/**
 * ʹ�����ɨ��,����MP3Player,�����Զ����ɵ�bean��MP3Player,�������Mp3Player,�����Զ����ɵ�bean��mp3Player
 * @author Jay
 * @date 2018��4��2��
 */

public class NoWebSpring {
	public static void main(String[] args){
		args = new String[]{"classpath:applicationContext.xml"};
		ApplicationContext actx = new ClassPathXmlApplicationContext(args);
		IMediaPlayer bean = (IMediaPlayer) actx.getBean("MP3Player");
		bean.play();
	}
}
