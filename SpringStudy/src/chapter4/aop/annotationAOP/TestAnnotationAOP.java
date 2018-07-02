package chapter4.aop.annotationAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter4.aop.annotationAOP.bean.IMediaPlayer;



/**
 * 主要说明注解方式进行切面编程
 * @After 通知方法会在目标方法返回或抛出异常后调用
 * @AfterReturning 通知方法会在目标方法返回后调用
 * @AfterThrowing 通知方法会在目标方法抛出异常后调用
 * @Around 通知方法会将目标方法封装起来
 * @Before 通知方法会在目标方法调用之前执行
 * 
 * 配置切面：
 * 1.JavaConfig或是自动装配，配置切面使用
 * @EnableAspectJAutoProxy 启动AspectJ自动代理
 * 注意：由于MediaPlayerHelper不是Component，所以需要单独在Config类单独配置(也可以添加Component注解)
 * 
 * 2.如果使用xml配置则在beans标签下添加
 * <aop:aspectj-autoproxy />
 * 
 * 
 * @author Jay
 * @date 2018年4月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes=AnnotationAOPConfig.class)*/
@ContextConfiguration(locations = {"classpath:chapter4/aop/annotationAOP/config_annotationAOP.xml"})
public class TestAnnotationAOP {
	
	@Autowired
	private IMediaPlayer player;
	
	@Test
	public void test(){
		System.out.println("test");
		player.play();
		//player.outputSongName("娱乐", 123);
	}
}
