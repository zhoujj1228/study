package chapter5.springMVC.web.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		//创建挡板
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		//模拟请求并返回
		ResultActions andExpect = mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.view().name("home"));
	}
	
	@Test
	public void testGetList() throws Exception{
		HomeController controller = new HomeController();
		//创建挡板
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		//模拟请求并返回
		ResultActions andExpect = mockMvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.view().name("home"));
	}
}
