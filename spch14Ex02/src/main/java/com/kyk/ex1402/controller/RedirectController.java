package com.kyk.ex1402.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {
	@RequestMapping("/studentConfirm")
	public String studentRedirect(@RequestParam("id") String id, Model model) {
		if(id.equals("abc")) {
			return "redirect:studentOk";
			//redirect:�� ���������� �����ϴ� Ű�����̴�
			//redirect:���� ���� .jsp�� ������ ���� �ƴ�. ��, ��û�����.
			//redirect:�� servlet�� sendRedirectó�� ����(��, Ŭ���̾�Ʈ���� ��û)
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk"; //�̶��� studentOk.jsp�� �̵�
	}
	
	@RequestMapping("/studentNg")
	public String sutdentNg(Model model) { 
		return "sutdentNg"; //studentNg.jsp
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		//redirect:�� jsp�̵��ô� �����η� jsp���� ����
		return "redirect:http://localhost:8181/ex1402/studentURL1.jsp";
		//context root�ٷ� �� jsp��δ� webapp�� ��Ÿ��. ��, webapp���� �ؿ� jsp���� ��
	}
}
