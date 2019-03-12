package study.springboot_log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.添加依赖
 * 2.添加配置文件
 * 3.程序添加日志语句
 * 
 * @author Jay
 * @date 2018年9月5日
 */

@SpringBootApplication
public class Log4j2Starter {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Starter.class, args);
    }

}
