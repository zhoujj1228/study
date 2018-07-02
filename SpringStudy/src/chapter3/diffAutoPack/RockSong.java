package chapter3.diffAutoPack;

import org.springframework.stereotype.Component;

public class RockSong implements ISong{
	String name = "´æÔÚ";
	@Override
	public String getSongName() {
		return name;
	}

}
