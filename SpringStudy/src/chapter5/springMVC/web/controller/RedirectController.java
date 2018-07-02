package chapter5.springMVC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import chapter5.springMVC.web.domain.TestDomain;
import chapter5.springMVC.web.service.IService;

@Controller
public class RedirectController {
	
	public static void main(String[] args){
		int i = (int)(Math.random() * 5);
		System.out.println(i);
	}
	
	@Autowired
	IService service;
	
	/**
	 * ʹ��ռλ�������ض���
	 * �ض��򻹻��ģ���еĻ���������·���������д���(��Ҫ��String������,�������Ͳ��ᴫ��)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "testPlaceHolderRedirect", method = RequestMethod.GET)
	public String testPlaceHolderRedirect(Model model){
		int randomIndex = (int)(Math.random() * service.getTestList().size());
		TestDomain td = service.getTestList().get(randomIndex);
		model.addAttribute("userId", td.getId());
		model.addAttribute("username", td.getName());
		model.addAttribute("age", td.getAge());
		System.out.println("testPlaceHolderRedirect randomIndex = " + randomIndex);
		return "redirect:/testPlaceHolderRedirectShow/{userId}";
	}
	
	@RequestMapping(value = "/testPlaceHolderRedirectShow/{id}", method = RequestMethod.GET)
	public String testPlaceHolderRedirectShow(Model model,
			@PathVariable(value="id") String domainId,
			@RequestParam(value="username", defaultValue="") String username,
			@RequestParam(value="age", defaultValue="0") int age
			){
		System.out.println("testPlaceHolderRedirectShow:" + domainId + "\t" + username + "\t" + age);
		return "error";
	}
	
	/**
	 * ʹ��RedirectAttributes���ض����д���������������
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "testFlashAttrRedirect", method = RequestMethod.GET)
	public String testFlashAttrRedirect(RedirectAttributes model){
		int randomIndex = (int)(Math.random() * service.getTestList().size());
		TestDomain td = service.getTestList().get(randomIndex);
		model.addAttribute("userId", td.getId());
		model.addFlashAttribute("testDomain", td);
		System.out.println("testFlashAttrRedirect randomIndex = " + randomIndex);
		return "redirect:/testFlashAttrRedirectShow/{userId}";
	}
	
	@RequestMapping(value = "/testFlashAttrRedirectShow/{id}", method = RequestMethod.GET)
	public String testFlashAttrRedirectShow(Model model,
			@PathVariable(value="id") String domainId,
			TestDomain td){
		System.out.println("testFlashAttrRedirectShow:" + domainId + "\t" + td.getName() + "\t" + td.getAge());
		return "error";
	}
	

	
	
	
}
