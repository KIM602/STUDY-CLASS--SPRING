package com.kyk.ex0701;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	public OtherStudent() {
		super();
	}

	public OtherStudent(String name, int age) {
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
	
	//초기화 후 추가작업 메서드와 소멸 후 추가작업을 처리
	//어노테이션 @PostConstruct와 @PreDestroy를 사용
	//서블렛에서도 사용
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod()");
	}
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
}
