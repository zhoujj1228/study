package chapter2.javaPack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import chapter2.autoPack.IMediaPlayer;
import chapter2.autoPack.ISong;
import chapter2.autoPack.MP3Player;
import chapter2.autoPack.Song;
/**
 *JavaConfig������
 * @author Jay
 * @date 2018��3��21��
 */

@Configuration
/*@ComponentScan*/
public class PlayerJavaPackConfig {
	@Bean
	public IMediaPlayer mp3Player(){
		return new MP3Player(song());
	}
	
	@Bean
	public ISong song(){
		return new Song();
	}
}
