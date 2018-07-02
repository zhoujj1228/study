package chapter3.diffAutoPack;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DiffAutoPackConfig {
	@Bean
	/*@Primary*/
	@Love
	@SmallNoise
	public ISong popularSong(){
		return new PopularSong();
	}
	
	@Bean
	@Qualifier("high")
	@BigNoise
	public ISong rockSong(){
		return new RockSong();
	}
	
	@Bean 
	public IMediaPlayer mp3Player(){
		return new MP3Player();
	}
}
