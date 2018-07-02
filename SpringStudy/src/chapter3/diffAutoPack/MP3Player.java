package chapter3.diffAutoPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Jay
 * @date 2018��3��21��
 */
public class MP3Player implements IMediaPlayer{
	

	@Autowired
	/*@Qualifier("rockSong")*/
	/*@Qualifier("high")*/
	@Love
	/*@BigNoise*/
	@SmallNoise
	ISong song;
	
	@Override
	public void play() {
		System.out.println("MP3Player play : " + song.getSongName());
	}

}
