package chapter4.aop.annotationAOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import chapter4.aop.annotationAOP.bean.IMediaPlayer;



/**
 * ��Ҫ˵��ע�ⷽʽ����������
 * @After ֪ͨ��������Ŀ�귽�����ػ��׳��쳣�����
 * @AfterReturning ֪ͨ��������Ŀ�귽�����غ����
 * @AfterThrowing ֪ͨ��������Ŀ�귽���׳��쳣�����
 * @Around ֪ͨ�����ὫĿ�귽����װ����
 * @Before ֪ͨ��������Ŀ�귽������֮ǰִ��
 * 
 * �������棺
 * 1.JavaConfig�����Զ�װ�䣬��������ʹ��
 * @EnableAspectJAutoProxy ����AspectJ�Զ�����
 * ע�⣺����MediaPlayerHelper����Component��������Ҫ������Config�൥������(Ҳ�������Componentע��)
 * 
 * 2.���ʹ��xml��������beans��ǩ�����
 * <aop:aspectj-autoproxy />
 * 
 * 
 * @author Jay
 * @date 2018��4��3��
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
		//player.outputSongName("����", 123);
	}
}
