package testClass;

import annotation.MyClassAnnotation;

@MyClassAnnotation("controller")
//@MyClassAnnotation() //Ϊ�վ�ʹ��Ĭ��ֵ
public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(TestClass.class.isAnnotationPresent(MyClassAnnotation.class)){
			MyClassAnnotation at = TestClass.class.getAnnotation(MyClassAnnotation.class);
			System.out.println("��������������ǣ�"+at.value());
		}
	}
}
