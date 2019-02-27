package springdb.dynamicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import util.SpringContextUtil;

@Component
public class SpringDBTest {
	@Autowired
	UserService userService;
	


	public static void main(String[] args) {
		new SpringDBTest().call();
	}

	private void call() {
		ApplicationContext springContext = SpringContextUtil.getAnnotationSpringContext(SpringDBConfig.class);
		SpringDBTest sdbt = springContext.getBean(SpringDBTest.class);
		sdbt.getUserService().transaction();
        //sdbt.getUs().transactionDo();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
