package com.kyk.ex1501.dto;

//Form에서 보내는 파라메터와 매핑되는 DTO
//컨트롤러에서 DTO객체를 파라메터로 사용하는 RequestMapping을 사용하면 데이터형이 자동 형변환
public class Student {
	private String name;
	private int id;
	
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
