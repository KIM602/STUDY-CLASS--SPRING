package com.kyk.ex1401.dto;

//클라이언트의 요청 파라메터에 매핑하는 DTO
public class StudentInformation {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public StudentInformation() {
		super();
	}

	public StudentInformation(String name, String age, String gradeNum, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	} 
	
}
