package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {
	//方法的类型
	public enum MethodType{ normal, controller, service, dataOpr};
	
	//来源方法的类型
	public MethodType sourceMethodType() default MethodType.normal;
	
	//目标方法的类型
	public MethodType targetMethodType() default MethodType.normal;
}
