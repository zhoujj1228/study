package chapter5.springMVC.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "My not found Exception")
public class MyNotFoundRuntimeException extends RuntimeException{

	public MyNotFoundRuntimeException(String ex) {
		super(ex);
	}

}
