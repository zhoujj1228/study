package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyClassAnnotation {
	//������������������ͣ�Ĭ��Ϊnormal���п��������з����࣬�����ݷ�����
	//ֻ��һ����Ա���ʹ��value
	//String type() default "normal";
	String value() default "normal";
}
