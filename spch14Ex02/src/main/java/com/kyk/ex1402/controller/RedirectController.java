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
			//redirect:은 스프링에서 제공하는 키워드이다
			//redirect:값의 값은 .jsp가 생략된 것이 아님. 즉, 요청경로임.
			//redirect:는 servlet의 sendRedirect처럼 동작(즉, 클라이언트에서 요청)
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(Model model) {
		return "studentOk"; //이때는 studentOk.jsp로 이동
	}
	
	@RequestMapping("/studentNg")
	public String sutdentNg(Model model) { 
		return "sutdentNg"; //studentNg.jsp
	}
	
	@RequestMapping("/studentURL1")
	public String studentURL1(Model model) {
		//redirect:로 jsp이동시는 절대경로로 jsp파일 지정
		return "redirect:http://localhost:8181/ex1402/studentURL1.jsp";
		//context root바로 밑 jsp경로는 webapp을 나타냄. 즉, webapp폴더 밑에 jsp파일 둠
	}
}
