package chapter4.aop.annotationAOP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("chapter4.aop.annotationAOP")
@EnableAspectJAutoProxy
public class AnnotationAOPConfig {
	@Bean
	public MediaPlayerHelper mediaPlayerHelper(){
		return new MediaPlayerHelper();
	}
}
