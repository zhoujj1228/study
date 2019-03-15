package test.autowiredAndprivate;

import org.springframework.stereotype.Component;

@Component
public class TestDomain {
	String name = "123";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
