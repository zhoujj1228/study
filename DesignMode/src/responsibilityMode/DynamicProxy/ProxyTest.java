package responsibilityMode.DynamicProxy;

import org.junit.Test;

/**
 * spring��AOPʹ�ö�̬��������ʵ�ֹ��̾����ڵ���MyInvocationHandler��invokeʱ��ȡ�Ƿ�����Ҫ֪ͨ�ģ��оͻ�ȡ������Ҫ֪ͨ����ŵ�����
 * ��Ȼ�����ִ�У�ͨ��������ʵ��ͬһ���ӿڣ�����invoke�������ƣ�������Ӧ���Ǹ���catch���Ĵ����б�����֮����ִ��
 * 
 * @author Jay
 * @date 2017��6��20��
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
