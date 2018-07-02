package chapter2.mixPack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import chapter2.autoPack.IMediaPlayer;
import chapter2.autoPack.ISong;
import chapter2.autoPack.MP3Player;
import chapter2.autoPack.Song;
/**
 * 注释JavaConfig的song bean使用xml导入bean
 * @author Jay
 * @date 2018年3月21日
 */

@Configuration
/*@ComponentScan*/
@ImportResource("classpath:/chapter2/mixPack/config_mixPack.xml")
public class MixPackConfig {
	@Bean
	public IMediaPlayer mp3Player(ISong song){
		return new MP3Player(song);
	}
	/*
	@Bean
	public ISong song(){
		return new Song();
	}*/
}
