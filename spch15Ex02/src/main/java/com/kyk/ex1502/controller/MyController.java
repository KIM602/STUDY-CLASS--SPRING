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
	//��ȿ�� üũ�� ���� DTO��ü �տ� @Valid������̼��� ����ϸ� �������� vlidate����
	public String create(@ModelAttribute("student") @Valid Student student, BindingResult result) {
		String page = "createDonePage";
		if(result.hasErrors()) {
			page = "formPage";
		}
		
		return page;
	}
	
	//pom.xml�� hibernate�� validation�� ����ҽô� @InitBinder����
	//StudentValidatorŬ������ validator�� ����
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
