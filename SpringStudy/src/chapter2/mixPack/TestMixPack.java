package chapter2.mixPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.autoPack.IMediaPlayer;
import chapter2.javaPack.PlayerJavaPackConfig;

/**
 * @ContextConfiguration(classes=MixPackConfig.class) 测试从JavaConfig中导入xml配置文件
 * @ContextConfiguration(locations = {"classpath:/chapter2/mixPack/config_mixPack.xml"}) 测试从xml配置文件导入JavaConfig
 * @author Jay
 * @date 2018年3月26日
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes=MixPackConfig.class)*/
@ContextConfiguration(locations = {"classpath:/chapter2/mixPack/config_mixPack.xml"})
public class TestMixPack {
	
	@Autowired
	private IMediaPlayer player;

	/*public IMediaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(IMediaPlayer player) {
		this.player = player;
		System.out.println(player);
		this.player.play();
	}*/
	@Test
	public void call() {
		System.out.println("play begin");
		player.play();
	}
}
