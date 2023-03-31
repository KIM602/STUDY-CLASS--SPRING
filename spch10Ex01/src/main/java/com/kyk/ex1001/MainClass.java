package com.kyk.ex1001;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStrudentInfo(); //pointcut
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo(); //pointcut
		
		ctx.close();
	}

}
