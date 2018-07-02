package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {
	//����������
	public enum MethodType{ normal, controller, service, dataOpr};
	
	//��Դ����������
	public MethodType sourceMethodType() default MethodType.normal;
	
	//Ŀ�귽��������
	public MethodType targetMethodType() default MethodType.normal;
}
