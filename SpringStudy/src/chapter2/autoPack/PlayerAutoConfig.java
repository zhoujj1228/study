package chapter2.autoPack;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 组件扫描默认是不启用的。
 * 使用@Configuration表示开启组件扫描
 * 使用@ComponentScan默认表示扫描当前类包及其子包的组件类
 * 使用@ComponentScan(basePackages={"beanCompScan","video"})可以指定多个基础扫描包
 * 使用@ComponentScan(basePackageClasses={CDPlayer.class,DVDPlayer.class})这些类所在的包会成为基础包
 * @author Jay
 * @date 2018年3月21日
 */

@Configuration
@ComponentScan
public class PlayerAutoConfig {
	
}
