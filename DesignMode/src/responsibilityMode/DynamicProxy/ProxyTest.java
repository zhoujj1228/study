package responsibilityMode.DynamicProxy;

import org.junit.Test;

/**
 * spring的AOP使用动态代理技术，实现过程就是在调用MyInvocationHandler的invoke时获取是否有需要通知的，有就获取所有需要通知的类放到容器
 * 里然后遍历执行（通常所有类实现同一个接口，调用invoke方法类似），错误应该是根据catch到的错误判别类型之后再执行
 * 
 * @author Jay
 * @date 2017年6月20日
 */
public class ProxyTest {
	@Test
	public void testProxy(){
		UserService userService = new UserServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(userService);
		UserService proxy = (UserService) handler.getProxy();
		proxy.add();
	}
}
