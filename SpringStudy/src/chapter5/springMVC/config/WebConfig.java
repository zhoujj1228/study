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
	
	//配置JSP视图解析器
	@Bean
	public ViewResolver viewResolver(){
        System.out.println("---------------WebConfig viewResolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		
		//如果需要JSP使用JSTL标签进行处理格式化和信息的话,需要将视图解析为JstlView
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		
		return resolver;
	}
	
	//将对静态资源的请求转发到Servlet容器中默认的Servlet上（脚本，css等）
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
		System.out.println("---------------WebConfig configureDefaultServletHandling");
	}
	
	//使用servlet3.0时使用以下MultipartResolver
	/*@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}*/
	
	/*//不使用servlet3.0时使用以下MultipartResolver
	@Bean
	public MultipartResolver multipartResolver() throws IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/multipart/"));
		multipartResolver.setMaxUploadSize(2097152);
		multipartResolver.setMaxInMemorySize(0);
		return multipartResolver;
	}*/
}
