package util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextUtil {
	
	public static ApplicationContext getAnnotationSpringContext(Class<?> cl){
		ApplicationContext context = new AnnotationConfigApplicationContext(cl);
		return context;
	}
	
	
	public static ApplicationContext initSpringContext(String[] path){
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		return context;
	}	
	public static ApplicationContext initSpringContext1(String path){
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		return context;
	}
	public static ApplicationContext initSpringContext2(String[] path){
		/*String[] path = {
			     "WebRoot/WEB-INF/applicationContext.xml",
			     "WebRoot/WEB-INF/applicationContext_task.xml"
			   }; */
		//String path = "WebRoot/WEB-INF/applicationContext*.xml"; 
		//String path = "classpath:地址"

		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		return context;
	}
	
	/**
	 * 这种方式适合于采用Spring框架的B/S系统，通过ServletContext对象获取ApplicationContext对象，然后在通过它获取需要的类实例。
	 * 上面两个工具方式的区别是，前者在获取失败时抛出异常，后者返回null。
	 * @param sc
	 * @return
	 */
	public static ApplicationContext getRunWebSpringContext(ServletContext sc){
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		return ac1;
	}
	
	/**
	 * 不依赖于servlet,不需要注入的方式。但是需要注意一点，在服务器启动时，Spring容器初始化时，不能通过以下方法获取Spring容器，
	 * 细节可以查看spring源码org.springframework.web.context.ContextLoader
	 * @return
	 */
	public static ApplicationContext getRunSpringContext(){
		return ContextLoader.getCurrentWebApplicationContext();
	}
	
}
