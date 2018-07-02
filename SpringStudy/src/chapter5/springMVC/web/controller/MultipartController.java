package chapter5.springMVC.web.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import chapter5.springMVC.web.domain.TestDomain;

@Controller
public class MultipartController {
	
	@RequestMapping(value="/testMultipart", method=RequestMethod.POST)
	public String testMultiPart(
			//@RequestPart("profilePicture") byte[] profilePicture,
			@RequestPart("profilePicture") MultipartFile profilePicture,
			TestDomain td,
			Model model){

		System.out.println("MultipartController testMultiPart");
		System.out.println(profilePicture.getOriginalFilename());
		model.addAttribute("errorMsg", "sMultiPart");
		try {
			profilePicture.transferTo(new File("D:/Test/tmp/abc.gif"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	@RequestMapping(value="/testMultipart", method=RequestMethod.GET)
	public String getTestMultiPart(){
		System.out.println("MultipartController getTestMultiPart");
		return "testMultipart";
	}
}
