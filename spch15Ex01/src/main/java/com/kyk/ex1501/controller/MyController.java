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
		//form�� �Ķ���͸� Student DTO�� �����ϴ� RequestMapping�� ����ϸ� @ModelAttribute�� ���
		//BindingResult�� ���������� �����ϴ� Errors�������̽��� ����ϴ� �������̽�
		//DTO��ü�� �Ķ���ͷ� ����ϸ� Modal�� �ڵ� ��ü�� ����
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator(); //��ȿ���� üũ�ϴ� Validator ���� Ŭ����
		validator.validate(student, result); //student��ü�� ���� ����üũ�Ͽ� ���� ������ result�� ����
		if(result.hasErrors()) {
			page = "formPage";
		}
		return page;
	}
}
