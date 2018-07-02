package chapter3.runInput;

/**
 * 主要说明外部输入和Spring表达式
 * 1.外部输入:
 * @PropertySource("classpath:/chapter3/runInput/app.properties") 修饰配置类，其中：
 * 使用Environment类获取值，如：
 * @Bean 
 * public BlankDisc disc() { 
		return new BlankDisc(
			env.getRequiredProperty("disc.title"), 
			env.getRequiredProperty("disc.artist")
		); 
	}
 * 
 * 使用占位符获取值，如：
 * <bean id="sgtPeppers" class="soundsystem.BlankDisc" c:_title="${disc.title}" c:_artist="${disc.artist}" />
 * 
 * 使用组件扫描时可以使用@value注解，如：
 * public BlankDisc( 
		@Value("${ disc. title}") String title, 
		@Value("${ disc. artist}") String artist
	){ 
		this. title = title; 
		this. artist = artist; 
	}
 * 
 * 
 * 2.使用Spring表达式（SpEL），其作用有：
 * 		使用bean的ID来引用bean；
 * 		调用方法和访问对象的属性；
 * 		对值进行算术、关系和逻辑运算；
 * 		正则表达式匹配；
 * 		集合操作。
 * 
 * SpEL表达式要放到“#{...}”之中，这与属性占位符有些类似，属性占位符需要放到“${...}”之中。
 * 
 * 例子：
 * #{mp3Player.song}
 * #{mp3Player.song.getSongName()}
 * #{T(System).currentTimeMillis()}
 * T()表达式会将java.lang.System视为Java中对应的类型，因此可以调用其static修饰的currentTimeMillis()方法。
 * T()运算符的真正价值在于它能够访问目标类型的静态方法和常量。
 * 
 * 
 * 
 * 
 * 
 * @author Jay
 * @date 2018年3月29日
 */

public class TestRunInput {
	
}
