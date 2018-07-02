package deepclone;


import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * ���:���ƶ�����ͬʱ�����������������Ҳ�Ḵ��
 * 
 * @author Jay
 * @date 2018��3��29��
 */

public class TestDeepClone {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Teacher t1 = new Teacher();
		t1.setName("teacher1");
		Student s1 = new Student();
		s1.teacher = t1;
		s1.id = "1";
		s1.name = "xiaoming";
		Student s2 = s1;
		Student sClone = s1.deepClone();
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
