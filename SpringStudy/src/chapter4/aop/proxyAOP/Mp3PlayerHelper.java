package chapter4.aop.proxyAOP;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class Mp3PlayerHelper implements MethodBeforeAdvice, AfterReturningAdvice{
	@Override
	public void before(Method method, Object[] objs, Object obj){
		System.out.println(method.getName() + "before");
		return;
	}
	
	@Override
	public void afterReturning(Object retValue, Method method, Object[] objs, Object obj){
		System.out.println(method.getName() + "afterReturning");
		return;
	}
}
