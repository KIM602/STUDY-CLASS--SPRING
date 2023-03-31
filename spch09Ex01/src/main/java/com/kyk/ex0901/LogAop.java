package com.kyk.ex0901;

import org.aspectj.lang.ProceedingJoinPoint;

//Ⱦ�ܱ��(������)�� ó���ϴ� Ŭ����
public class LogAop {
	//xml�� <aop:����ñ�>���� �����ϴ� method�� ���� ���ش�.
	//<aop:around poincut-ref="publicM" method="loggerAop">
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		//ProceedingJoinPoint�� joinpoint������ ����ǰ��ִ� ���¸� ó���ϴ� Ŭ������ AOP���� ������
		String signatureStr = joinpoint.getSignature().toShortString();
		//signatureStr�� Ŭ������.����Ʈ���� �޼���
		System.out.println(signatureStr + " is strat.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed(); //�������� ��ü�� ��ȯ�ϰ� ������ �޼��� ������ �ߴ��ϰ� �ִٰ� �ٽɱ�ɸ޼��尡 ����Ǹ� �ٽ� ����
			return obj; //try���� ���Ͻô� finally�� ���� �Ŀ� ����
		}
		finally {
			long et =System.currentTimeMillis();
			System.out.println(signatureStr + "is finished");
			System.out.println(signatureStr + "����ð� : " + (et - st));
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

