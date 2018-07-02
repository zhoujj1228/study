package chapter3.conditionBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Jay
 * @date 2018Äê3ÔÂ21ÈÕ
 */
@Component
public class MP3Player implements IMediaPlayer{
	
	
	ISong song;
	
	@Autowired
	public MP3Player(ISong song){
		this.song = song;
	}
	
	@Override
	public void play() {
		System.out.println("MP3Player play : " + song.getSongName());
	}

}
