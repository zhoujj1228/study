package chapter3.runInput;

/**
 * ��Ҫ˵���ⲿ�����Spring���ʽ
 * 1.�ⲿ����:
 * @PropertySource("classpath:/chapter3/runInput/app.properties") ���������࣬���У�
 * ʹ��Environment���ȡֵ���磺
 * @Bean 
 * public BlankDisc disc() { 
		return new BlankDisc(
			env.getRequiredProperty("disc.title"), 
			env.getRequiredProperty("disc.artist")
		); 
	}
 * 
 * ʹ��ռλ����ȡֵ���磺
 * <bean id="sgtPeppers" class="soundsystem.BlankDisc" c:_title="${disc.title}" c:_artist="${disc.artist}" />
 * 
 * ʹ�����ɨ��ʱ����ʹ��@valueע�⣬�磺
 * public BlankDisc( 
		@Value("${ disc. title}") String title, 
		@Value("${ disc. artist}") String artist
	){ 
		this. title = title; 
		this. artist = artist; 
	}
 * 
 * 
 * 2.ʹ��Spring���ʽ��SpEL�����������У�
 * 		ʹ��bean��ID������bean��
 * 		���÷����ͷ��ʶ�������ԣ�
 * 		��ֵ������������ϵ���߼����㣻
 * 		������ʽƥ�䣻
 * 		���ϲ�����
 * 
 * SpEL���ʽҪ�ŵ���#{...}��֮�У���������ռλ����Щ���ƣ�����ռλ����Ҫ�ŵ���${...}��֮�С�
 * 
 * ���ӣ�
 * #{mp3Player.song}
 * #{mp3Player.song.getSongName()}
 * #{T(System).currentTimeMillis()}
 * T()���ʽ�Ὣjava.lang.System��ΪJava�ж�Ӧ�����ͣ���˿��Ե�����static���ε�currentTimeMillis()������
 * T()�������������ֵ�������ܹ�����Ŀ�����͵ľ�̬�����ͳ�����
 * 
 * 
 * 
 * 
 * 
 * @author Jay
 * @date 2018��3��29��
 */

public class TestRunInput {
	
}
