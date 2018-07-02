package chapter3.conditionBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Conditional(ConditionPlayer.class) 使用ConditionPlayer作为其条件,返回false为不加载该bean
 * @author Jay
 * @date 2018年3月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConditionBeanConfig.class)
public class ConditionBeanTest {
	@Test
	public void test(){
		System.out.println("play begin");
		player.play();
	}
	
	@Autowired
	private IMediaPlayer player;
}
