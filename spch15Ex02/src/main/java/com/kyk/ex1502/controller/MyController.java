package com.kyk.ex1502.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyk.ex1502.dto.Student;
import com.kyk.ex1502.util.StudentValidator;

@Controller
public class MyController {
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "formPage";
	}
	
	@RequestMapping("/create")
	//유효성 체크를 위해 DTO객체 앞에 @Valid어노테이션을 사용하면 스프링이 vlidate실행
	public String create(@ModelAttribute("student") @Valid Student student, BindingResult result) {
		String page = "createDonePage";
		if(result.hasErrors()) {
			page = "formPage";
		}
		
		return page;
	}
	
	//pom.xml에 hibernate와 validation을 사용할시는 @InitBinder구현
	//StudentValidator클래스를 validator로 설정
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
