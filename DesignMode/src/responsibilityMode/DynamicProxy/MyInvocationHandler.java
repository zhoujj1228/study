package responsibilityMode.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	//目标对象
	private Object target;
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//在目标对象的方法前执行
		System.out.println("--------before-------");
		
		Object result = method.invoke(target, args);
		
		//在目标对象的方法后执行
		System.out.println("--------after-------");
		return result;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

}
