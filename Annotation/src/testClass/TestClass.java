package testClass;

import annotation.MyClassAnnotation;

@MyClassAnnotation("controller")
//@MyClassAnnotation() //为空就使用默认值
public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(TestClass.class.isAnnotationPresent(MyClassAnnotation.class)){
			MyClassAnnotation at = TestClass.class.getAnnotation(MyClassAnnotation.class);
			System.out.println("该类的作用类型是："+at.value());
		}
	}
}
