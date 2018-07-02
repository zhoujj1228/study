package chapter5.springMVC.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter5.springMVC.web.exception.MyControllerException;
import chapter5.springMVC.web.exception.MyNotFoundRuntimeException;

@Controller
public class TestExceptionController {
	
	/**
	 * ���ڲ����Զ���exceptionӳ��Ϊhttp��Ӧ��
	 * @return
	 */
	@RequestMapping(value = "/testExceptionToHttpStatus", method = RequestMethod.GET)
	public String testExceptionToHttpStatus(){
		throw new MyNotFoundRuntimeException("MyNotFound RuntimeException");
	}
	
	/**
	 * ���ڲ��Ե�ǰController�´����׳���MyNotFoundRuntimeException
	 * @return
	 * @throws MyControllerException 
	 */
	@RequestMapping(value = "/testControllerExceptionHandler", method = RequestMethod.GET)
	public String testControllerExceptionHandler() throws MyControllerException{
		System.out.println("testControllerExceptionHandler MyControllerException");
		//model.addAttribute("errorMsg", "MyControllerException");
		throw new MyControllerException("MyControllerException");
	}
	
	/**
	 * ���ڴ���ǰController���׳���MyNotFoundRuntimeException
	 * @return
	 */
	//@ExceptionHandler(MyControllerException.class)
	public String controllerHandleException(){
		System.out.println("controllerHandleException");
		return "error";
	}
}
