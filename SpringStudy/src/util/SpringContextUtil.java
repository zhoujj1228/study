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
		//String path = "classpath:��ַ"

		ApplicationContext context = new FileSystemXmlApplicationContext(path);
		return context;
	}
	
	/**
	 * ���ַ�ʽ�ʺ��ڲ���Spring��ܵ�B/Sϵͳ��ͨ��ServletContext�����ȡApplicationContext����Ȼ����ͨ������ȡ��Ҫ����ʵ����
	 * �����������߷�ʽ�������ǣ�ǰ���ڻ�ȡʧ��ʱ�׳��쳣�����߷���null��
	 * @param sc
	 * @return
	 */
	public static ApplicationContext getRunWebSpringContext(ServletContext sc){
		ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
		return ac1;
	}
	
	/**
	 * ��������servlet,����Ҫע��ķ�ʽ��������Ҫע��һ�㣬�ڷ���������ʱ��Spring������ʼ��ʱ������ͨ�����·�����ȡSpring������
	 * ϸ�ڿ��Բ鿴springԴ��org.springframework.web.context.ContextLoader
	 * @return
	 */
	public static ApplicationContext getRunSpringContext(){
		return ContextLoader.getCurrentWebApplicationContext();
	}
	
}
