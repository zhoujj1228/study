package test.autowiredAndprivate;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		//String path = "classpath:��ַ"

		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		return context;
	}
	
}
