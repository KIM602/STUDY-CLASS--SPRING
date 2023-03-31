package com.kyk.jsonAjax;

public class Jamong {
	private String Name;
	private int age;
	
	public Jamong() {
		super();
	}
	
	public Jamong(String name, int age) {
		super();
		this.Name = name;
		this.age = age;
	}

	public String getName() {
		return Name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
