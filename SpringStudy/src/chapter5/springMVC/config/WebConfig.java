package chapter5.springMVC.config;

import java.io.IOException;

import javax.servlet.Registration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("chapter5.springMVC.web")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	//����JSP��ͼ������
	@Bean
	public ViewResolver viewResolver(){
        System.out.println("---------------WebConfig viewResolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		//�����ҪJSPʹ��JSTL��ǩ���д����ʽ������Ϣ�Ļ�,��Ҫ����ͼ����ΪJstlView
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		
		return resolver;
	}
	
	//���Ծ�̬��Դ������ת����Servlet������Ĭ�ϵ�Servlet�ϣ��ű���css�ȣ�
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
		System.out.println("---------------WebConfig configureDefaultServletHandling");
	}
	
	//ʹ��servlet3.0ʱʹ������MultipartResolver
	/*@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}*/
	
	/*//��ʹ��servlet3.0ʱʹ������MultipartResolver
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/multipart/"));
		multipartResolver.setMaxUploadSize(2097152);
		multipartResolver.setMaxInMemorySize(0);
		return multipartResolver;
	}*/
}
