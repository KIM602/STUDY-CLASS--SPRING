package com.kyk.ex1501.dto;

//Form���� ������ �Ķ���Ϳ� ���εǴ� DTO
//��Ʈ�ѷ����� DTO��ü�� �Ķ���ͷ� ����ϴ� RequestMapping�� ����ϸ� ���������� �ڵ� ����ȯ
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
