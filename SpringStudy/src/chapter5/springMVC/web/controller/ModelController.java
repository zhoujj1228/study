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
	
	//���ַ�ʽ����������model��
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getTestList(Model model){
		//������addAttribute()�������Ҳ�ָ��key��ʱ����ôkey�����ֵ�Ķ��������ƶ�ȷ���������keyӦ����testDomainList
		//model.addAttribute(service.getTestList(0, 3));
		
		//ָ��key��ʽ
		model.addAttribute("testList", service.getTestList(0, 3));
		
		//ʹ�����ַ�ʽ�跽������ΪMap model
		//model.put("testList", service.getTestList(0, 3));
		
		//���ַ�ʽ����Ҫ��������Ϊ�գ���û����ʽ�趨model������û��ָ����ͼ����ͼ���������·���ó����������list����model�����ֵ�Ķ��������ƶ�ȷ��
		//return service.getTestList(0, 3)
		return "list";
	}
}
