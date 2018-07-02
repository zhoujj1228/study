package testMethod;

import java.lang.reflect.Method;

import annotation.MyMethodAnnotation;
import annotation.MyMethodAnnotation.MethodType;

public class TestMethod {

	public static void main(String[] args) {
		Method[] declaredMethods = TestMethod.class.getDeclaredMethods();
		for(Method method : declaredMethods){
			if(method.isAnnotationPresent(MyMethodAnnotation.class)){
				System.out.println("Annotion-name:"+method.getName());
			}else{
				System.out.println("noAnnotion:"+method.getName());
			}
		}
	}
	

	@MyMethodAnnotation(sourceMethodType=MethodType.controller)
	public void startService(){
		
	}
	
	@MyMethodAnnotation(targetMethodType=MethodType.dataOpr)
	public void endService(){
		
	}
	
	public void testNoAnnotationService(){
		
	}

}
