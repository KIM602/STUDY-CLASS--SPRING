package com.kej.ex0601;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//설정파일 xml을 두개로 만듬
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX2.xml";
		
		//생성시 파라미터로 2개 경로 문자열을 사용하면 두개를 포함하는 스프링 콘테이너가 생김
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation1,configLocation2);
		
		//GenericXmlApplicationContext.GenericXmlApplicationContext(String... resourceLocations)
		//파라미터가 String... resourceLpcations처럼 데이터형 뒤에 ...이 오면 가변형 파라미터로 파라미터수를 임의로 사용(vararg)
		Student student1 = ctx.getBean("student1",Student.class);
		//앞의 student1은 자바에서의 객체명이고 뒤의 student1은 xml에서의 bean id임
		System.out.println(student1.getName()); //홍길동
		System.out.println(student1.getHobbys()); //수영,요리
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1",StudentInfo.class);
		//StudentInfo bean은 student1 bean사용
		Student student2 = studentInfo.getStudent();//student1 bean을 사용한 객체이므로 student2는 student1객체
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3",Student.class);
		System.out.println(student3.getName()); //홍길자
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}
		else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family",Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
	}

}
