package chapter5.springMVC.web.servlet;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class MyServletInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletcontext) throws ServletException {
		//添加自定义servlet
		Dynamic myServlet = servletcontext.addServlet("myServlet", MyServlet.class);
		myServlet.addMapping("/myServlet");
		
		
		//添加自定义Filter
		javax.servlet.FilterRegistration.Dynamic myFilter = servletcontext.addFilter("myFilter", MyFilter.class);
		myFilter.addMappingForUrlPatterns(null, false, "/homepage/*");
		
		/*//在采用Servlet初始化类方法加载DispatcherServlet下,multipart最基本配置
		DispatcherServlet ds = new DispatcherServlet();
		Dynamic springServlet = servletcontext.addServlet("springServlet", ds);
		springServlet.addMapping("/");
		springServlet.setMultipartConfig(new MultipartConfigElement("/tmp/multipart/"));*/
	}

}
