package chapter2.mixPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.autoPack.IMediaPlayer;
import chapter2.javaPack.PlayerJavaPackConfig;

/**
 * @ContextConfiguration(classes=MixPackConfig.class) ���Դ�JavaConfig�е���xml�����ļ�
 * @ContextConfiguration(locations = {"classpath:/chapter2/mixPack/config_mixPack.xml"}) ���Դ�xml�����ļ�����JavaConfig
 * @author Jay
 * @date 2018��3��26��
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
