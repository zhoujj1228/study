package chapter5.springMVC.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chapter5.springMVC.web.domain.TestDomain;
import chapter5.springMVC.web.service.IService;

@Controller
public class FormController {
	IService service;
	
	@Autowired
	FormController(IService service){
		this.service = service;
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping(value = "/registerbylist", method = RequestMethod.GET)
    public String toRegisterByList(){
        System.out.println("call FormController doRegister method");
        return "registerbylist";
    }
	
	/*@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(Model model, TestDomain td){
		System.out.println("call doRegister method");
		boolean isSuccess = service.saveDomain(td);
		if(!isSuccess){
			model.addAttribute("errorMsg", "doRegister service.saveDomain(td) fail");
			return "error";
		}
		return "redirect:/getSomeOne/" + td.getId();
	}*/
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(Model model, TestDomain td, Error error){
		System.out.println("call doRegister method");
		boolean isSuccess = service.saveDomain(td);
		if(!isSuccess){
			model.addAttribute("errorMsg", "doRegister service.saveDomain(td) fail");
			return "error";
		}
		return "redirect:/getSomeOne/" + td.getId();
	}

	@ResponseBody
	@RequestMapping(value = "/registerbylist", method = RequestMethod.POST)
    public String doRegisterByList(@RequestBody List<TestDomain> tdList){
        System.out.println("call doRegisterByList method");
        for(TestDomain td : tdList){
            System.out.println("doRegisterByList tdList : " + td.getId());
        }
        return null;
    }
}
