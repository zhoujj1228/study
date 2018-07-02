package chapter2.javaPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.autoPack.IMediaPlayer;
/**
 * ��Ҫ˵��JavaConfig����
 * ʹ��Configuration��Bean��Autowiredע��
 * @Bean ע���������һ��bean������˵������������Է��ض�Ӧʵ��
 * spring�����ʵ�����ǵ����ģ�ÿ�ε���song()�����������أ����spring�����Ѿ��ж�Ӧʵ����ֱ�ӷ���ʵ��
 * @author Jay
 * @date 2018��3��21��
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PlayerJavaPackConfig.class)
public class TestJavaPack {
	@Test
	public void call() {
		System.out.println("play begin");
		player.play();
	}
	

	/*@Autowired(required=false)*/
	private IMediaPlayer player;


	/*@Autowired*/
	public void insertMediaPlayer(IMediaPlayer player){
		this.player = player;
	}
	
	
	public IMediaPlayer getPlayer() {
		return player;
	}

	@Autowired
	public void setPlayer(IMediaPlayer player) {
		System.out.println(player);
		this.player = player;
	}
	

}
