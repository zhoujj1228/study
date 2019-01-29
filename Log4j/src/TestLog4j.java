import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 *		<dependency>
 *			<groupId>log4j</groupId>
 *				<artifactId>log4j</artifactId>
 *				<version>1.2.17</version>
 *			</dependency>
 * @author Jay
 * @date 2018Äê12ÔÂ27ÈÕ
 */
public class TestLog4j {
	public static void main(String[] args){
		TestLog4j tl = new TestLog4j();
		tl.call();
	}

	private void call() {
		String log4jPath = "/config/log4j.properties";
		//String rootPath = this.getClass().getResource("/").getPath();
		String rootPath = System.getProperty("user.dir");
		log4jPath = rootPath + log4jPath;
		/*File file = new File(log4jPath);
		System.out.println(log4jPath + file.exists());*/
		PropertyConfigurator.configure(log4jPath);
		new Test().call();
		
	}
}

class Test{
	private static final Log log = LogFactory.getLog(Test.class);

	public void call() {
		log.debug("test debug");
		log.error("test error");
	}
}
