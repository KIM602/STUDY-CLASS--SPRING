package com.kej.ex0602;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//bean을 생성하는 java클래스

@Configuration
//@Configuration어노테이션은 ApplicationConfig클래스가 스프링 설정 관련 클래스임을 나타낸다.
public class ApplicationConfig {
	@Bean
	//@Bean어노테이션은 스프링의 bean을 설정하는 어노테이션 
	public Student student1() {
		//리턴타입은 bean의 클래스형
		//메서드의 이름은 bean이름
		ArrayList<String> hobbys = new ArrayList<String>();
		
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		
		student.setHeight(180);
		student.setWeight(80);
		
		return student;//bean student1설정
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		
		hobbys.add("독서");
		hobbys.add("음악");
		
		Student student = new Student("홍길자", 20, hobbys); //생성자로 속성을 설정
		
		student.setHeight(160);
		student.setWeight(50);
		
		return student; //bean student2 설정
	}
}
