package com.kyk.ex0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//스프링컨테이너 생명주기
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("스프링컨테이너 생성");
		
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("스프링컨테이너 설정");
		ctx.refresh();
		//afterPropertiesSet()이 자동 호출됨
		//@PostConstruct 자동 실행
		System.out.println("스프링컨테이너 초기화");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("스프링컨테이너 사용");
		
		ctx.close();
		//destroy()메서드 자동 호출
		//@PreDestroy 자동 실행
		System.out.println("소멸");
	}

}
