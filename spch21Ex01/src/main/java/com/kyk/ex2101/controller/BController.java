package com.kyk.ex2101.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kyk.ex2101.command.BCommand;
import com.kyk.ex2101.command.BListCommand;
import com.kyk.ex2101.command.BWriteCommand;
import com.kyk.ex2101.dto.WriteFormDto;
import com.kyk.ex2101.util.Constant;

@Controller
public class BController {
	
	BCommand command = null;
	//BCommand의 인터페이스 객체(다형성을 이용해 인터페이스 개체로 선언하고 값은 이를 구현한 클래스 객체 사용)
	//bean을 주입하는 어노테이션 @Autowired를 사용하여 bean 주입
	//AbstractApplicationContext스프링 객체를 구해 getBean()메서드로 주입하지 않고 @Autowired사용
	//@Autowired는 생성자, 필드, set메서드로 설정을 해줌
	
	
	private JdbcTemplate template;
	@Autowired //set메서드로 template객체 bean을 주입받음
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
	/* 생성자 방식
	 * public BController(JdbcTemplate template) {
	 * 	this.template = template;
	 *		Constant.template = template;
	 * }
	 */
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list요청");
		command = new BListCommand();
		command.excute(request, model);
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		System.out.println("writeForm요청");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(WriteFormDto writeFormDto, HttpServletRequest request, Model model) {
		//form의 데이터와 매핑되는 DTO클래스를 파라메터로 사용하면 바로 dto객체가 생성
		System.out.println("write요청");
		command = new BWriteCommand();
		model.addAttribute("wdto", writeFormDto);
		command.excute(request, model);
		return "redirect:list";
	}
}
