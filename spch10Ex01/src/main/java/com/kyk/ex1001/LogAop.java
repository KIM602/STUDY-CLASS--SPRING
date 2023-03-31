package com.kyk.ex1001;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//������̼��� �̿��� �ٽɱ�� Ŭ����
@Aspect
public class LogAop {
	@Pointcut("within(com.kyk.ex1001.*)")
	//@Pointcut������̼��� ()�ȿ� �������(xml���� expression)�� �����ָ� �޼��带 ���� ���ش�.
	//����ñ� ������̼� @Around ��� �޼��� �̸��� �Ķ���ͷ� ���
	private void pointcutMethod() {
		;
	}
	@Around("pointcutMethod()") //@Around()�� xml�� <aop:around>�� �ش��ϴ� ������̼�
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		//�������� �޼��� �̸��� Ŭ������.�޼�������� ��ȯ
		System.out.println(signatureStr + " is start. ");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}
		finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " ����ð� : " + (et - st));
		}
	}
	
	@Before("within(com.kyk.ex1001.*)") //�Ķ���ͷ� �ٷ� xml�� expression���
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
