package chapter3.conditionBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConditionBeanConfig {
	@Bean
	@Conditional(ConditionPlayer.class)
	public ISong ljjSong(){
		Song song = new Song();
		song.name = "һǧ���Ժ�";
		return song;
		
	}
	
	@Bean
	public IMediaPlayer mp3Player(){
		return new MP3Player(ljjSong());
	}
	
	/*@Bean
	public ISong zjlSong(){
		Song song = new Song();
		song.name = "ǧ��֮��";
		return song;
		
	}*/
	
	
}
