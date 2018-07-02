package chapter2.autoPack;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * ���ɨ��Ĭ���ǲ����õġ�
 * ʹ��@Configuration��ʾ�������ɨ��
 * ʹ��@ComponentScanĬ�ϱ�ʾɨ�赱ǰ��������Ӱ��������
 * ʹ��@ComponentScan(basePackages={"beanCompScan","video"})����ָ���������ɨ���
 * ʹ��@ComponentScan(basePackageClasses={CDPlayer.class,DVDPlayer.class})��Щ�����ڵİ����Ϊ������
 * @author Jay
 * @date 2018��3��21��
 */

@Configuration
@ComponentScan
public class PlayerAutoConfig {
	
}
