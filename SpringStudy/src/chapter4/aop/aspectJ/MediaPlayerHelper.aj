package chapter4.aop.aspectJ;


public aspect MediaPlayerHelper{
	
	public MediaPlayerHelper(){}
	
	pointcut mypointcut() : execution(* chapter4.aop.aspectJ..*.play(..));
	
	afterReturning() : mypointcut(){
		System.out.println("aspectJ IMediaPlayer some method afterReturning");
	}
	
}