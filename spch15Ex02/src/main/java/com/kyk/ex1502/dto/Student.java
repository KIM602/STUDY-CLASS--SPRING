package com.kyk.ex1502.dto;

public class Student {
	private String name;
	private int id; //form의 값이 @Requestmapping설정시 자동 형변환 되어서 설정
	
	public Student() {
		super();
	}
	
	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
}
