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
		song.name = "一千年以后";
		return song;
		
	}
	
	@Bean
	public IMediaPlayer mp3Player(){
		return new MP3Player(ljjSong());
	}
	
	/*@Bean
	public ISong zjlSong(){
		Song song = new Song();
		song.name = "千里之外";
		return song;
		
	}*/
	
	
}
