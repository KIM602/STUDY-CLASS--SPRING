package com.kyk.ex0901;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		//SPRING�� AOP�� �޼��忡�� ����
		Student student = ctx.getBean("student", Student.class); //AOP�� ���� �ȵ�(�ڹٳ� ���������� �����ϴ� API�޼����̹Ƿ� ���� �ȵ�
		student.getStudentInfo(); //����Ʈ������ �����(����ڰ� ���� Ŭ������ �޼����̹Ƿ�)
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //����Ʈ������ �����(����ڰ� ���� Ŭ������ �޼����̹Ƿ�)
		
		ctx.close(); //AOP�� ���� �ȵ�(�ڹٳ� ���������� �����ϴ� API�޼����̹Ƿ� ���� �ȵ�
		
		//��������� around�� before -> before -> around�� after -> after -> after-returning ->around�� after
	}

}
