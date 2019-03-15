package test.autowiredAndprivate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class SpringTest {
	@Autowired
	private TestDomain testDomain;

	public static void main(String[] args) {
		String[] path = new String[]{"classpath:test/autowiredAndprivate/applicationContext.xml"};
		ApplicationContext springContext = SpringContextUtil.initSpringContext(path);
		SpringTest st = (SpringTest) springContext.getBean(SpringTest.class);
		st.show();
	}
	
	
	public void show(){
		System.out.println(testDomain.getName());
	}

}
