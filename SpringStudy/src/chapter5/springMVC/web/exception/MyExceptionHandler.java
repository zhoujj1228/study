package chapter5.springMVC.web.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.portlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

	/**
	 * 用于处理所有Controller下抛出的MyNotFoundRuntimeException
	 * @return
	 */
	/*@ExceptionHandler(MyControllerException.class)
	public String allControllerHandleException(){
		//HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		return "error";
	}*/
	
	/**
	 * 为什么不能添加参数和为什么不能使用ModelView
	 * @return
	 */
	@ExceptionHandler(MyControllerException.class)
	public ModelAndView allControllerHandleException(){
		//HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		System.out.println("------allControllerHandleException");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorMsg", "MyControllerException");
		return mv;
	}
}
