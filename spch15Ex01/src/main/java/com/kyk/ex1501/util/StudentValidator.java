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
		//Object target은 유효성 검사 대상 객체
		//Errors errors는 BIndingResult result의 상위로 result값을 받는 객체
		//Errors errors객체는 에러내용을 저장할 객체
		System.out.println("validate()");
		Student student = (Student)target;
		/*
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "trouble"); //name속성으로 값은 trouble을 주어 에러 등록
		}
		*/
		//위의 주석 부분을 한줄로 처리(단, String에 한해서)
		ValidationUtils.rejectIfEmpty(errors, "name", "trouble");
		
		//String이 아닌 int는 원래대로 처리
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studnetId is 0");
			errors.rejectValue("id", "trouble");
		}
	}

}
