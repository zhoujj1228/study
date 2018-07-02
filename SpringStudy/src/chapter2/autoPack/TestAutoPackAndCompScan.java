package chapter2.autoPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ��Ҫ˵���Զ�װ��
 * ʹ��Configuration��Component��ComponentScan��Autowiredע��
 * ֻ����һ��ʵ�ֲ�������װ�䣬����ٶ�һ��IMediaPlayerʵ����Ҳ���@Component���ǾͻᱨΨһ�Դ���
 * @Autowired ע������Ժͷ�����������Զ�װ��
 * ����@Autowired(required=false)������Զ�װ�䣬����������
 * ����@Autowiredע�⵽�ķ������ᾡ����������
 * ����@Autowired��@Inject�����໥���
 * 
 * ��Ҫ˵�����ɨ��
 * ���ɨ��Ĭ���ǲ����õġ�
 * @ContextConfiguration ˵����������Ҫ���ص�������
 * @Configuration ��ʾ����Ϊ������
 * @ComponentScan Ĭ�ϱ�ʾɨ�赱ǰ��������Ӱ��������
 * ʹ��@ComponentScan(basePackages={"beanCompScan","video"})����ָ���������ɨ���
 * ʹ��@ComponentScan(basePackageClasses={CDPlayer.class,DVDPlayer.class})��Щ�����ڵİ����Ϊ������
 * @Component ֪ͨspring�����Ϊ����࣬��Ϊ����ഴ��bean��ע��Ҳ����ʹ��@Named��
 * ʹ��@Component("thePlayer")����IdΪthePlayer, �������Ĭ��Ϊ����ĸСд������
 * 
 * 
 * @author Jay
 * @date 2018��3��21��
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
