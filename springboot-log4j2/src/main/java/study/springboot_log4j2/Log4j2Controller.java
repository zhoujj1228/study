package study.springboot_log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {
    private static Logger logger = LoggerFactory.getLogger(Log4j2Controller.class);
    
    @RequestMapping("/log4j2test")
    String home() {
        System.out.println("log4j2test");
        if(logger.isDebugEnabled()){
            logger.debug("Log4j2Controller call home method");
        }
        return "Hello World!";
    }
}
