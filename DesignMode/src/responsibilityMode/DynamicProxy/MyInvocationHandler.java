package responsibilityMode.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	//Ŀ�����
	private Object target;
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//��Ŀ�����ķ���ǰִ��
		System.out.println("--------before-------");
		
		Object result = method.invoke(target, args);
		
		//��Ŀ�����ķ�����ִ��
		System.out.println("--------after-------");
		return result;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

}
