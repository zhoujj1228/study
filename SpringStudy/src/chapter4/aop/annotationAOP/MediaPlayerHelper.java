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
	
	
	//ȷ��AspectJ���汾��JDK�汾��Ӧ
	@Pointcut("execution(* chapter4..*.play(..))")
	public void myPointCut(){}

	//ʹ�������õ��е�,ƥ��chapter4�������Ӱ��µ�����play����
	@AfterReturning("myPointCut()")
	public void afterReturning1(){
		System.out.println("chapter4 and the subPackage play afterReturning1");
		return;
	}
	
	
	//ƥ��IMediaPlayer�µ����ⷽ��
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.*(..))")
	public void before(){
		System.out.println("IMediaPlayer some method before");
		return;
	}
	
	//ƥ��IMediaPlayer�µ����ⷽ��
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.*(..))")
	public void before2(JoinPoint jp){
		System.out.println("IMediaPlayer some method before2, "
				+ "method:" + jp.getSignature().getName() 
				+ "--" + "object:" + jp.getTarget()
				+ "--" + "args:" + jp.getArgs());
		return;
	}
	
	//ƥ��chapter4.aop.annotationAOP.bean���µ�����play����
	@Before("execution(* chapter4.aop.annotationAOP.bean.*.play(..))")
	public void before1(){
		System.out.println("IMediaPlayer some method before1");
		return;
	}	
	

	//ƥ��chapter4�������Ӱ��µ�����play����,Ŀ�귽�����ػ����׳��쳣��ִ��
	@After("execution(* chapter4..*.play(..))")
	public void after(){
		System.out.println("chapter4 and the subPackage play afterReturning or afterThrowing");
		return;
	}
	
	//ƥ��chapter4�������Ӱ��µ�������play��ʼ�����ķ���
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
	
	
	
	@Before("execution(* chapter4.aop.annotationAOP.bean.IMediaPlayer.outputSongName(String, int)) && args(name, id)")
	public void beforeOutputSongName(String name, int id){
		System.out.println("IMediaPlayer beforeOutputSongName before, args name " + name + "\t" + id);
		return;
	}
	
}
