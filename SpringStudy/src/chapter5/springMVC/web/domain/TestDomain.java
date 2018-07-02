package chapter5.springMVC.web.domain;

public class TestDomain {
	String id;
	String name;
	int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TestDomain(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TestDomain() {
		super();
	}
}
