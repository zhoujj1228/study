package chapter5.springMVC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import chapter5.springMVC.web.domain.TestDomain;
import chapter5.springMVC.web.service.IService;

@Controller
public class ParamController {
	IService service;
	
	@Autowired
	ParamController(IService service){
		this.service = service;
	}
	
	
	//处理查询参数,虽然参数都是String类型,但会自动转换为方法参数指定类型
	@RequestMapping(value = "/listByNum", method = RequestMethod.GET)
	public String getTestListByNum(Model model,
			@RequestParam(value="start", defaultValue="0") int start,
			@RequestParam(value="end", defaultValue="5") int end
			){
		model.addAttribute("testList", service.getTestList(start, end));
		return "list";
	}
	
	//通过路径参数接收输入
	/* 可以直接使用以下例子
	 * @RequestMapping(value = "/getSomeOne/{id}", method = RequestMethod.GET)
	 * public String getSomeOneById(Model model,@PathVariable String id)*/
	@RequestMapping(value = "/getSomeOne/{id}", method = RequestMethod.GET)
	public String getSomeOneById(Model model,
			@PathVariable(value="id") String domainId){
		System.out.println("call getSomeOneById method");
		TestDomain td = service.getOneDoaminById(domainId);
		model.addAttribute("testDomain", td);
		return "someone";
	}
	
	
	
}
