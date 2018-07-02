package chapter3.diffAutoPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 主要说明自动装配过程中多个实现类如何进行装配
 * @Primary 用于修饰Bean,可以作用于@Component修饰的类,也可以作用于@Bean修饰的方法,表示这个Bean是首选的
 * @Qualifier("rockSong") 用于修饰需要自动装配的属性或是方法，声明需要注入的bean（比@Primary高级）
 * @Qualifier("high") 用于修饰需要自动装配的属性或是方法，当Bean同样被该注解修饰，选择该Bean注入
 * 当需要多个@Qualifier时，可以自定义注解(如BigNoise、SmallNoise、Love)
 * 当被注入被多个自定义注解（@Qualifier）修饰时，会寻找必须符合所有注解的Bean，没有则无法注入
 * 
 * @author Jay
 * @date 2018年3月28日
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DiffAutoPackConfig.class)
public class TestDiffAutoPack {
	
	@Autowired
	public IMediaPlayer player;
	
	@Test
	public void test(){
		player.play();
	}
}
