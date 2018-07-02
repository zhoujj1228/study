package chapter4.aop.pojoAOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class MediaPlayerHelper{
	
	
	public void before(){
		System.out.println("IMediaPlayer some method before");
		return;
	}
	
	public void before1(){
		System.out.println("IMediaPlayer some method before1");
		return;
	}	
	

	public void after(){
		System.out.println("chapter4 and the subPackage play afterReturning or afterThrowing");
		return;
	}
	
	public void afterThrowing(){
		System.out.println("chapter4 and the subPackage play afterThrowing");
		return;
	}

	public void afterReturning(){
		System.out.println("chapter4 and the subPackage play afterReturning");
		return;
	}
	
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
	
	public void around1(ProceedingJoinPoint jp, String name, int id){
		try {
			System.out.println("around1 before");
			jp.proceed();
			System.out.println("around1 afterReturn");
		} catch (Throwable e) {
			System.out.println("around1 afterThrow");
			e.printStackTrace();
		}
	}
	
	
	public void beforeOutputSongName(String name, int id){
		System.out.println("IMediaPlayer beforeOutputSongName before, args name = " + name + "\t" + id);
		return;
	}
	
}
