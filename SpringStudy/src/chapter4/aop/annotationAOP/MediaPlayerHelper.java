package chapter4.aop.annotationAOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
/*@Component*/
public class MediaPlayerHelper{
	
	
	//确认AspectJ包版本与JDK版本对应
	@Pointcut("execution(* chapter4..*.play(..))")
	public void myPointCut(){}

	//使用声明好的切点,匹配chapter4包及其子包下的任意play方法
	@AfterReturning("myPointCut()")
	public void afterReturning1(){
		System.out.println("chapter4 and the subPackage play afterReturning1");
		return;
	}
	
	
	//匹配IMediaPlayer下的任意方法
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.*(..))")
	public void before(){
		System.out.println("IMediaPlayer some method before");
		return;
	}
	
	//匹配IMediaPlayer下的任意方法
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.*(..))")
	public void before2(JoinPoint jp){
		System.out.println("IMediaPlayer some method before2, "
				+ "method:" + jp.getSignature().getName() 
				+ "--" + "object:" + jp.getTarget()
				+ "--" + "args:" + jp.getArgs());
		return;
	}
	
	//匹配chapter4.aop.annotationAOP.bean包下的任意play方法
	@Before("execution(* chapter4.aop.annotationAOP.bean.*.play(..))")
	public void before1(){
		System.out.println("IMediaPlayer some method before1");
		return;
	}	
	

	//匹配chapter4包及其子包下的任意play方法,目标方法返回或是抛出异常后执行
	@After("execution(* chapter4..*.play(..))")
	public void after(){
		System.out.println("chapter4 and the subPackage play afterReturning or afterThrowing");
		return;
	}
	
	//匹配chapter4包及其子包下的任意以play开始命名的方法
	@AfterThrowing("execution(* chapter4..*.play*(..))")
	public void afterThrowing(){
		System.out.println("chapter4 and the subPackage play afterThrowing");
		return;
	}

	@AfterReturning("execution(* chapter4..*.play*(..))")
	public void afterReturning(){
		System.out.println("chapter4 and the subPackage play afterReturning");
		return;
	}
	
	//该方法切入有参数有返回值的方法会出错
	@Around("execution(* chapter4..*.play*(..))")
	public void around(ProceedingJoinPoint jp){
		try {
			System.out.println("around before");
			jp.proceed();
			System.out.println("around afterReturn");
		} catch (Throwable e) {
			System.out.println("around afterThrow");
			e.printStackTrace();
		}
	}
	
	//要使用这样的才能正常执行有参数有返回值的方法,不然在进行bean实例化就会报错,该方法也适用于无参数无返回值的方法，上面around会报错
	@Around("execution(* chapter4..*.play*(..))")
	public Object around2(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around before");
		Object proceed = jp.proceed(jp.getArgs());
		System.out.println("around afterReturn");
		return proceed;
	}
	
	
	
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.outputSongName(String, int)) && args(name, id)")
	public void beforeOutputSongName(String name, int id){
		System.out.println("IMediaPlayer beforeOutputSongName before, args name " + name + "\t" + id);
		return;
	}
	
}
