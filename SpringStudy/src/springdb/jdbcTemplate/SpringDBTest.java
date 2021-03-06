package springdb.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import util.SpringContextUtil;

@Component
public class SpringDBTest {
	@Autowired
	UserService us;
	

	public static void main(String[] args) {
		new SpringDBTest().call();
	}

	private void call() {
		ApplicationContext springContext = SpringContextUtil.getAnnotationSpringContext(SpringDBConfig.class);
		SpringDBTest sdbt = springContext.getBean(SpringDBTest.class);
		sdbt.getUs().transaction();
	}
	
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
