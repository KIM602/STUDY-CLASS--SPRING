package com.kyk.ex0901;

import org.aspectj.lang.ProceedingJoinPoint;

//횡단기능(공통기능)을 처리하는 클래스
public class LogAop {
	//xml의 <aop:실행시기>에서 지정하는 method를 정의 해준다.
	//<aop:around poincut-ref="publicM" method="loggerAop">
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//ProceedingJoinPoint는 joinpoint에서의 진행되고있는 상태를 처리하는 클래스로 AOP에서 제공함
		String signatureStr = joinpoint.getSignature().toShortString();
		//signatureStr은 클래스명.포인트컷의 메서드
		System.out.println(signatureStr + " is strat.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed(); //진행중인 객체를 반환하고 현재의 메서드 진행을 중단하고 있다가 핵심기능메서드가 종료되면 다시 진행
			return obj; //try에서 리턴시는 finally를 수행 후에 실행
		}
		finally {
			long et =System.currentTimeMillis();
			System.out.println(signatureStr + "is finished");
			System.out.println(signatureStr + "경과시간 : " + (et - st));
		}
	}
	
	//<aop:before pointcut-ref="publicM" method="beforeAdvice"></aop:before>
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
	//<aop:after-returning pointcut-ref="publicM" method="afterReturningAdvice">
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	
	//<aop:after-throwing pointcut-ref="publicM" method="afterThrowingAdvice">
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	//<aop:after pointcut-ref="publicM" method="afterAdvice"></aop:after>
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}

