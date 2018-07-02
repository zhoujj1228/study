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
	
	//进行Multipart基础配置
	@Override
	protected void customizeRegistration(Dynamic registration){
		//最基础配置，配置临时文件夹
		//registration.setMultipartConfig(new MultipartConfigElement("/tmp/multipart/"));
		
		//配置临时文件夹，配置单个上传文件最大容量，配置整个请求最大容量，配置达到指定（0字节默认）容量写到临时路径中
		//ide环境测试使用相对路径容易出错
		registration.setMultipartConfig(new MultipartConfigElement("d:/Test/tmp/", 2097512, 4194303, 0));
	}

	
}
