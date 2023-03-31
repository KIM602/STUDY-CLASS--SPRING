package com.kyk.ex1501.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyk.ex1501.dto.Student;
import com.kyk.ex1501.util.StudentValidator;

@Controller
public class MyController {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "formPage";
	}
	
	@RequestMapping("/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {
		//form의 파라메터를 Student DTO로 매핑하는 RequestMapping을 사용하며 @ModelAttribute를 사용
		//BindingResult는 에러내용을 전달하는 Errors인터페이스를 상속하는 인터페이스
		//DTO객체를 파라메터로 사용하면 Modal에 자동 객체값 저장
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator(); //유효성을 체크하는 Validator 구현 클래스
		validator.validate(student, result); //student객체에 대해 에러체크하여 에러 내용을 result에 전달
		if(result.hasErrors()) {
			page = "formPage";
		}
		return page;
	}
}
