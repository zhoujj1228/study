package chapter4.aop.pojoAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter4.aop.pojoAOP.bean.IMediaPlayer;


/**
 * 也就是使用xml配置切面，xml配置不用改动到任何代码
 * 
 * <aop:advisor> 定义AOP通知器
 * <aop:after> 定义AOP后置通知（不管被通知的方法是否执行成功）
 * <aop:after-returning> 定义AOP返回通知
 * <aop:after-throwing> 定义AOP异常通知
 * <aop:around> 定义AOP环绕通知
 * <aop:aspect> 定义一个切面
 * <aop:aspectj-autoproxy> 启用@AspectJ注解驱动的切面
 * <aop:before> 定义一个AOP前置通知
 * <aop:config> 顶层的AOP配置元素。大多数的<aop:*> 元素必须包含在<aop:config> 元素内
 * <aop:declare-parents> 以透明的方式为被通知的对象引入额外的接口
 * <aop:pointcut> 定义一个切点
 * 
 * @author Jay
 * @date 2018年4月8日
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(classes=AnnotationAOPConfig.class)*/
@ContextConfiguration(locations = {"classpath:chapter4/aop/pojoAOP/config_pojoAOP.xml"})
public class TestPojoAOP {
	
	@Autowired
	private IMediaPlayer player;
	
	@Test
	public void test(){
		System.out.println("test");
		//player.play();
		player.outputSongName("娱乐", 123);
	}
}