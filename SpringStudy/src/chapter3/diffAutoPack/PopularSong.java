package chapter3.diffAutoPack;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class PopularSong implements ISong{
	String name = "������";
	@Override
	public String getSongName() {
		return name;
	}

}
