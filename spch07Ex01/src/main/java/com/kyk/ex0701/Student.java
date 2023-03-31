package com.kyk.ex0701;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//InitializingBean은 스프링컨테이너 초기화시 빈을 초기화해주는 인터페이스
//DisposableBean은 스프링컨테이너 소멸시 자원을 해소하는 인터페이스
public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	
	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void destroy() throws Exception {
		//DisposableBean의 추상메서드
		System.out.println("destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean의 추상메서드
		System.out.println("afterPropertiesSet()");
	}
}
