package chapter3.beanEffectRange;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * ��Ҫ˵��Bean������
 * Bean�����÷�Χ�����֣�Singleton��Prototype��Session��Request
 * ����������Ӧ��ֻ��һ��ʵ��
 * ԭ�ͣ�ÿ��ע����Ǵ������Ļ�ȡ���ᴴ��һ��ʵ��
 * �Ự����web�Ự�У�Ϊÿ���Ự����һ��ʵ��
 * ������web�Ự�У�Ϊÿ�����󴴽�һ��ʵ��
 * 
 * ͨ����Springʵ�����Ե�����ʽ����
 * @Scope ʹ�ø�ע���������bean����������@Component��@Bean���ã�
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 * @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES) ����ʹ�õ�����ģʽ
 * @Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.INTERFACES)
 * ����ģʽӦ�ó���:��ʹ��ԭʵ��֮ǰ����֮����д���, �����������ԭʵ��һ��, ����ʹ�ô��������չ����
 * 
 * ��xml������ʹ��scope��������bean���磺
 * <bean id="notepad" class="com.myapp.Notepad" scope="prototype" />
 * <bean id="notepad" class="com.myapp.Notepad" scope="session">
 * 		<aop:scoped-proxy proxy-target-class="false" />
 * </bean>
 * Ĭ������£�����ʹ��CGLib����Ŀ����Ĵ�����������Ҳ���Խ�proxy-target-class��������Ϊfalse������Ҫ�������ɻ��ڽӿڵĴ���
 * 
 * 
 * @author Jay
 * @date 2018��3��28��
 */

public class TestBeanEffectRange {
	
}
