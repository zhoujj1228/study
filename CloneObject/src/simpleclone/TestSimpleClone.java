package simpleclone;


import org.junit.Before;
import org.junit.Test;

/**
 * 浅复制:复制只是对象本身,对对象的引用其他对象不会复制,只是复制引用
 * 复制前后teacher对象是同一个地址,一个对象改变teacher另一个对象的teacher也会改变
 * 
 * @author Jay
 * @date 2018年3月29日
 */

public class TestSimpleClone {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() throws CloneNotSupportedException {
		Teacher t1 = new Teacher();
		t1.setName("teacher1");
		Student s1 = new Student();
		s1.teacher = t1;
		s1.id = "1";
		s1.name = "xiaoming";
		Student s2 = s1;
		Student sClone = (Student) s1.clone();
		
		sClone.setName("sClone");
		t1.setName("teacher1update");
		System.out.println(s1);
		System.out.println(sClone);
		System.out.println(s1 == s2);
		System.out.println(s1 == sClone);
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getTeacher());
		System.out.println(s1.getTeacher().getName());
		System.out.println(sClone.getId());
		System.out.println(sClone.getName());
		System.out.println(sClone.getTeacher());
		System.out.println(sClone.getTeacher().getName());
	}

}
