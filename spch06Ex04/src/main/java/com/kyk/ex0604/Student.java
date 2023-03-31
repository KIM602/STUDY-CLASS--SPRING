package com.kyk.ex0604;

import java.util.ArrayList;

public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobbys;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	private double height;
	private double weight;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, ArrayList<String> hobbys, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
		this.height = height;
		this.weight = weight;
	}
	public Student(String name, int age, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}
}
