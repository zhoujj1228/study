package simpleclone;


import org.junit.Before;
import org.junit.Test;

/**
 * ǳ����:����ֻ�Ƕ�����,�Զ���������������󲻻Ḵ��,ֻ�Ǹ�������
 * ����ǰ��teacher������ͬһ����ַ,һ������ı�teacher��һ�������teacherҲ��ı�
 * 
 * @author Jay
 * @date 2018��3��29��
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
