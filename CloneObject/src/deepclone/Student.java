package deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Student implements Serializable{
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
	
	public Student deepClone() throws IOException, ClassNotFoundException{
		byte[] bytes = deepCloneObjectToByteArray(this);
		//System.out.println(bytes);
		Student obj = (Student)deepCloneByteArrayToObject(bytes);
		return obj;
	}
	
	public byte[] deepCloneObjectToByteArray(Object obj) throws IOException{
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		
		return bos.toByteArray();
	}
	
	public Object deepCloneByteArrayToObject(byte[] bytes) throws IOException, ClassNotFoundException{
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
}
