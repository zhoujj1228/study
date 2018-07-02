package chapter3.diffAutoPack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ��Ҫ˵���Զ�װ������ж��ʵ������ν���װ��
 * @Primary ��������Bean,����������@Component���ε���,Ҳ����������@Bean���εķ���,��ʾ���Bean����ѡ��
 * @Qualifier("rockSong") ����������Ҫ�Զ�װ������Ի��Ƿ�����������Ҫע���bean����@Primary�߼���
 * @Qualifier("high") ����������Ҫ�Զ�װ������Ի��Ƿ�������Beanͬ������ע�����Σ�ѡ���Beanע��
 * ����Ҫ���@Qualifierʱ�������Զ���ע��(��BigNoise��SmallNoise��Love)
 * ����ע�뱻����Զ���ע�⣨@Qualifier������ʱ����Ѱ�ұ����������ע���Bean��û�����޷�ע��
 * 
 * @author Jay
 * @date 2018��3��28��
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
