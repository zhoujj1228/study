package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnnotation {
	//用于描述类的作用类型，默认为normal，有控制器，有服务类，有数据访问类
	//只有一个成员最好使用value
	//String type() default "normal";
	String value() default "normal";
}
