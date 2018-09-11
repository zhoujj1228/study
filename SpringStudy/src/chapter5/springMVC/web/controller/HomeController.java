package chapter5.springMVC.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/home", "/homepage"})
public class HomeController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	/*@RequestMapping(method=RequestMethod.GET)*/
	public String home(){
		System.out.println("-----home------");
		return "home";
	}
	
	
}
