package chapter4.aop.pojoAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter4.aop.pojoAOP.bean.IMediaPlayer;


/**
 * Ҳ����ʹ��xml�������棬xml���ò��øĶ����κδ���
 * 
 * <aop:advisor> ����AOP֪ͨ��
 * <aop:after> ����AOP����֪ͨ�����ܱ�֪ͨ�ķ����Ƿ�ִ�гɹ���
 * <aop:after-returning> ����AOP����֪ͨ
 * <aop:after-throwing> ����AOP�쳣֪ͨ
 * <aop:around> ����AOP����֪ͨ
 * <aop:aspect> ����һ������
 * <aop:aspectj-autoproxy> ����@AspectJע������������
 * <aop:before> ����һ��AOPǰ��֪ͨ
 * <aop:config> �����AOP����Ԫ�ء��������<aop:*> Ԫ�ر��������<aop:config> Ԫ����
 * <aop:declare-parents> ��͸���ķ�ʽΪ��֪ͨ�Ķ����������Ľӿ�
 * <aop:pointcut> ����һ���е�
 * 
 * @author Jay
 * @date 2018��4��8��
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
		player.outputSongName("����", 123);
	}
}