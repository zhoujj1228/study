package chapter2.javaPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.autoPack.IMediaPlayer;
/**
 * 主要说明JavaConfig配置
 * 使用Configuration、Bean、Autowired注解
 * @Bean 注解可以声明一个bean，并且说明这个方法可以返回对应实例
 * spring里面的实例都是单例的，每次调用song()方法都会拦截，如果spring容器已经有对应实例，直接返回实例
 * @author Jay
 * @date 2018年3月21日
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
