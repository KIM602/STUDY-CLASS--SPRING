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
	//BCommand�� �������̽� ��ü(�������� �̿��� �������̽� ��ü�� �����ϰ� ���� �̸� ������ Ŭ���� ��ü ���)
	//bean�� �����ϴ� ������̼� @Autowired�� ����Ͽ� bean ����
	//AbstractApplicationContext������ ��ü�� ���� getBean()�޼���� �������� �ʰ� @Autowired���
	//@Autowired�� ������, �ʵ�, set�޼���� ������ ����
	
	
	private JdbcTemplate template;
	@Autowired //set�޼���� template��ü bean�� ���Թ���
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = template;
	}
	
	/* ������ ���
	 * public BController(JdbcTemplate template) {
	 * 	this.template = template;
	 *		Constant.template = template;
	 * }
	 */
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		System.out.println("list��û");
		command = new BListCommand();
		command.excute(request, model);
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		System.out.println("writeForm��û");
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(WriteFormDto writeFormDto, HttpServletRequest request, Model model) {
		//form�� �����Ϳ� ���εǴ� DTOŬ������ �Ķ���ͷ� ����ϸ� �ٷ� dto��ü�� ����
		System.out.println("write��û");
		command = new BWriteCommand();
		model.addAttribute("wdto", writeFormDto);
		command.excute(request, model);
		return "redirect:list";
	}
}
