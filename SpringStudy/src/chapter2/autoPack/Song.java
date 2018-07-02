package chapter2.autoPack;

import org.springframework.stereotype.Component;

@Component
public class Song implements ISong{
	String name = "∆ﬂ¿Ôœ„";
	@Override
	public String getSongName() {
		return name;
	}

}
