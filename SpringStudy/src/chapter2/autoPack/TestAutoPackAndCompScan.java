package chapter2.autoPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 主要说明自动装配
 * 使用Configuration、Component、ComponentScan、Autowired注解
 * 只能有一个实现才能正常装配，如果再多一个IMediaPlayer实现类也添加@Component，那就会报唯一性错误
 * @Autowired 注解的属性和方法都会进行自动装配
 * 其中@Autowired(required=false)代表会自动装配，但并不必须
 * 其中@Autowired注解到的方法都会尽量满足依赖
 * 其中@Autowired与@Inject可以相互替代
 * 
 * 主要说明组件扫描
 * 组件扫描默认是不启用的。
 * @ContextConfiguration 说明上下文需要加载的配置类
 * @Configuration 表示该类为配置类
 * @ComponentScan 默认表示扫描当前类包及其子包的组件类
 * 使用@ComponentScan(basePackages={"beanCompScan","video"})可以指定多个基础扫描包
 * 使用@ComponentScan(basePackageClasses={CDPlayer.class,DVDPlayer.class})这些类所在的包会成为基础包
 * @Component 通知spring这个类为组件类，并为这个类创建bean（注：也可以使用@Named）
 * 使用@Component("thePlayer")代表Id为thePlayer, 如果不填默认为首字母小写的类名
 * 
 * 
 * @author Jay
 * @date 2018年3月21日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PlayerAutoConfig.class)
public class TestAutoPackAndCompScan {
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
		this.player = player;
	}
	

}
