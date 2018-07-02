package chapter5.springMVC.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{ RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{ WebConfig.class};
	}
	
	//����Multipart��������
	@Override
	protected void customizeRegistration(Dynamic registration){
		//��������ã�������ʱ�ļ���
		//registration.setMultipartConfig(new MultipartConfigElement("/tmp/multipart/"));
		
		//������ʱ�ļ��У����õ����ϴ��ļ����������������������������������ôﵽָ����0�ֽ�Ĭ�ϣ�����д����ʱ·����
		//ide��������ʹ�����·�����׳���
		registration.setMultipartConfig(new MultipartConfigElement("d:/Test/tmp/", 2097512, 4194303, 0));
	}

	
}
