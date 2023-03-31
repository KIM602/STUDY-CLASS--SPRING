package com.kyk.ex1301;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyk.ex1301.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		//@RequestParam�� request��ü�� �Ķ����(��, query���̳� form�� �����̸��� name�Ӽ���)
		//�Ķ���Ͱ��� ���������� ���ڿ��� ó���ϳ� @RequestParam�� �ڵ� ����ȯ
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "checkId";
	}
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
		//HttpServletRequest��ü�� �̿��Ͽ� ��û ó��
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "confirmId";
	}
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		//Member DTO��ü�� �Ķ���Ͱ��� ����
		Member member = new Member();
		//�Ķ������ ���� ��������� ����
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		//Model addAttribute(String attributeName, Object attributeValue)
		//addAttribute�޼��� �Ӽ��̸��� ���ڿ���, ���� Object�̹Ƿ� ���� �͵� ��, ��ȯ�� Model��ü
		return "join";
	}
	
	@RequestMapping("/join")
	public String join(Member member) {
		 //RequestMapping �޼����� �Ķ���͸� DTO��ü�� ó���ϸ� DTO��ü�� �Ķ���Ͱ� �ڵ� ����ǰ�
		//Model��ü���� �ڵ� �����
		//Model�� �Ӽ����� �Ķ���͸�, ���� �Ķ���� �� model.addAttribute?("member", member)
		return "joinM";
	}
	
	@RequestMapping("/student/{studentId}")
	//{studentId�� ��ΰ� �ƴ� ������ Ÿ������ ����
	//@PathVariable������̼����� �Ķ���� ���� ������ ó��
	public String getStrudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "studentView";
	}
}
