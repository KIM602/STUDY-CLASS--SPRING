package com.kyk.ex0901;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		//SPRING의 AOP는 메서드에만 적용
		Student student = ctx.getBean("student", Student.class); //AOP가 적용 안됨(자바나 스프링에서 제공하는 API메서드이므로 적용 안됨
		student.getStudentInfo(); //포인트컷으로 적용됨(사용자가 만든 클래스의 메서드이므로)
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //포인트컷으로 적용됨(사용자가 만든 클래스의 메서드이므로)
		
		ctx.close(); //AOP가 적용 안됨(자바나 스프링에서 제공하는 API메서드이므로 적용 안됨
		
		//적용순서는 around의 before -> before -> around의 after -> after -> after-returning ->around의 after
	}

}
