package com.kej.ex0602;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//자바에서 bean을 생성할 시에는 AnnotationConfigApplicationContext클래스를 사용하여 스프링 콘테이너 객체를 만든다
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1",Student.class);
		//getBean의 student1은 ApplicationConfig클래스에서 생성한 bean이름
		
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbys());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());
		
		Student student2 = ctx.getBean("student2",Student.class);
		//getBean의 student1은 ApplicationConfig클래스에서 생성한 bean이름
		
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbys());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());
		
		ctx.close();
	}
	

}
