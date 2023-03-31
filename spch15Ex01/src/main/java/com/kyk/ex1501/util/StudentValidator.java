package com.kyk.ex1501.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kyk.ex1501.dto.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Object target�� ��ȿ�� �˻� ��� ��ü
		//Errors errors�� BIndingResult result�� ������ result���� �޴� ��ü
		//Errors errors��ü�� ���������� ������ ��ü
		System.out.println("validate()");
		Student student = (Student)target;
		/*
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); //name�Ӽ����� ���� trouble�� �־� ���� ���
		}
		*/
		//���� �ּ� �κ��� ���ٷ� ó��(��, String�� ���ؼ�)
		ValidationUtils.rejectIfEmpty(errors, "name", "trouble");
		
		//String�� �ƴ� int�� ������� ó��
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studnetId is 0");
			errors.rejectValue("id", "trouble");
		}
	}

}
