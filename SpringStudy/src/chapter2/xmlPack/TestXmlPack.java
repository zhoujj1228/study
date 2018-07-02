package chapter2.xmlPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter2.autoPack.IMediaPlayer;

/**
 * 注意:
 * classpath:chapter4/aop/annotationAOP/config_annotationAOP.xml 使用"/"进行分割
 * 项目根路径为classpath
 * 
 * @author Jay
 * @date 2018年4月8日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestXmlPack {
	
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
