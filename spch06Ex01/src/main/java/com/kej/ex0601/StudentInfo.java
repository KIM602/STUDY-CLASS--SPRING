package com.kej.ex0601;

public class StudentInfo {
	private Student student;

	//생성자가 최소 1개라도 존재하면 기본형 생성자를 사용하려면 필수로 정의를 해줌
	public StudentInfo() {
		super();
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
