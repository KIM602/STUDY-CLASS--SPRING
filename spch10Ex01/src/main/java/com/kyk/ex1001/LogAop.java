package com.kyk.ex1001;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//어노테이션을 이용한 핵심기능 클래스
@Aspect
public class LogAop {
	@Pointcut("within(com.kyk.ex1001.*)")
	//@Pointcut어노테이션은 ()안에 적용범위(xml에서 expression)를 적어주며 메서드를 정의 해준다.
	//적용시기 어노테이션 @Around 등에서 메서드 이름을 파라메터로 사용
	private void pointcutMethod() {
		;
	}
	@Around("pointcutMethod()") //@Around()는 xml의 <aop:around>에 해당하는 어노테이션
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		//진행중인 메서드 이름을 클래스명.메서드명으로 반환
		System.out.println(signatureStr + " is start. ");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}
		finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}
	
	@Before("within(com.kyk.ex1001.*)") //파라메터로 바로 xml의 expression사용
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
