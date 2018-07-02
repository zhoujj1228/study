package simpleclone;

public class Student implements Cloneable{
	String id;
	String name;
	Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
