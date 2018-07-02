package chapter5.springMVC.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("MyFilter destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter doFilter");
		chain.doFilter(req, rsp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter init");
		
	}

}
