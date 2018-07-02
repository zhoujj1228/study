package chapter5.springMVC.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp) throws IOException{
		rsp.getWriter().write("Test ×Ô¶¨Òå servlet");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rsp) throws IOException{
		doGet(req, rsp);
	}
}
