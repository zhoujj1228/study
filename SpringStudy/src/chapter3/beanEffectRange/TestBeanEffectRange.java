package chapter3.beanEffectRange;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * 主要说明Bean作用域
 * Bean的作用范围有四种：Singleton、Prototype、Session、Request
 * 单例：整个应用只有一个实例
 * 原型：每次注入或是从上下文获取都会创建一个实例
 * 会话：在web会话中，为每个会话创建一个实例
 * 请求：在web会话中，为每个请求创建一个实例
 * 
 * 通常是Spring实例是以单例形式存在
 * @Scope 使用该注解进行修饰bean的作用域（与@Component与@Bean共用）
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 * @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.INTERFACES) 其中使用到代理模式
 * @Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.INTERFACES)
 * 代理模式应用场景:在使用原实现之前或是之后进行处理, 但对外表现与原实现一样, 可以使用代理进行拓展功能
 * 
 * 在xml配置中使用scope属性修饰bean，如：
 * <bean id="notepad" class="com.myapp.Notepad" scope="prototype" />
 * <bean id="notepad" class="com.myapp.Notepad" scope="session">
 * 		<aop:scoped-proxy proxy-target-class="false" />
 * </bean>
 * 默认情况下，它会使用CGLib创建目标类的代理。但是我们也可以将proxy-target-class属性设置为false，进而要求它生成基于接口的代理：
 * 
 * 
 * @author Jay
 * @date 2018年3月28日
 */

public class TestBeanEffectRange {
	
}
