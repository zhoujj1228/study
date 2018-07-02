package chapter4.aop.aspectJ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter4.aop.annotationAOP.bean.IMediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes=AnnotationAOPConfig.class)*/
@ContextConfiguration(locations = {"classpath:chapter4/aop/aspectJ/config_aspectjAOP.xml"})
public class TestAspectJ {
	
	@Autowired
	private IMediaPlayer player;
	
	@Test
	public void test(){
		System.out.println("test");
		player.play();
		//player.outputSongName("”È¿÷", 123);
	}
}
