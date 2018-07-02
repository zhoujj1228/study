package chapter5.springMVC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter5.springMVC.web.service.IService;

public class ModelController {

IService service;
	
	@Autowired
	ModelController(IService service){
		this.service = service;
	}
	
	//各种方式把数据填入model中
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getTestList(Model model){
		//当调用addAttribute()方法并且不指定key的时候，那么key会根据值的对象类型推断确定。这里的key应该是testDomainList
		//model.addAttribute(service.getTestList(0, 3));
		
		//指定key方式
		model.addAttribute("testList", service.getTestList(0, 3));
		
		//使用这种方式需方法参数为Map model
		//model.put("testList", service.getTestList(0, 3));
		
		//这种方式，需要方法参数为空，并没有显式设定model，而且没有指定视图，视图会根据请求路径得出（这里会是list），model会根据值的对象类型推断确定
		//return service.getTestList(0, 3)
		return "list";
	}
}
