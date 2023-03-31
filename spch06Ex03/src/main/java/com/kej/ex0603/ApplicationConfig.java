package com.kej.ex0603;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration //스프링 IOC설정 파일로 만드는 어노테이션
public class ApplicationConfig {
	@Bean //스프링 콘테이너의 bean을 만드는 어노테이션
	//메서드는 bean의 클래스를 리턴타입으로 하고 메서드 이름은 bean이름
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys);
		
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
}
