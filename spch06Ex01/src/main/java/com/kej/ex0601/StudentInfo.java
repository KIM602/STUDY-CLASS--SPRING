package com.kej.ex0601;

public class StudentInfo {
	private Student student;

	//�����ڰ� �ּ� 1���� �����ϸ� �⺻�� �����ڸ� ����Ϸ��� �ʼ��� ���Ǹ� ����
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
