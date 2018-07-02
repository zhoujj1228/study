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
	 * ���ڴ�������Controller���׳���MyNotFoundRuntimeException
	 * @return
	 */
	/*@ExceptionHandler(MyControllerException.class)
	public String allControllerHandleException(){
		//HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		return "error";
	}*/
	
	/**
	 * Ϊʲô������Ӳ�����Ϊʲô����ʹ��ModelView
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
