package com.kyk.ex0901;

public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int gradeNum, int classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}


	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public int getGradeNum() {
		return gradeNum;
	}


	public int getClassNum() {
		return classNum;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}


	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	// getter setter 메서드외 추가 메서드
	public void getStudentInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("학년 : " + getGradeNum());
		System.out.println("반 : " + getClassNum());		
	}
}
