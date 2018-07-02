package chapter5.springMVC.web.exception;

public class MyControllerException extends Exception{

	public MyControllerException(String msg){
		super(msg);
	}
	public MyControllerException(){
		super();
	}
}
