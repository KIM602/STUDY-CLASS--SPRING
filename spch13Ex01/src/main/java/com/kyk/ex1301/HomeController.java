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
		//@RequestParam은 request객체의 파라메터(즉, query문이나 form의 원소이름인 name속성값)
		//파라메터값은 서블렛에서는 문자열로 처리하나 @RequestParam은 자동 형변환
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "checkId";
	}
	
	@RequestMapping("/confirmId")
	public String confirmId(HttpServletRequest request, Model model) {
		//HttpServletRequest객체를 이용하여 요청 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "confirmId";
	}
	
	@RequestMapping("/join1")
	public String join1(@RequestParam("name") String name, @RequestParam("id") String id,
			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
		//Member DTO객체에 파라메터값을 설정
		Member member = new Member();
		//파라메터의 값을 멤버변수에 설정
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		//Model addAttribute(String attributeName, Object attributeValue)
		//addAttribute메서는 속성이름은 문자열로, 값은 Object이므로 뭐가 와도 됨, 반환은 Model객체
		return "join";
	}
	
	@RequestMapping("/join")
	public String join(Member member) {
		 //RequestMapping 메서드의 파라메터를 DTO객체로 처리하면 DTO객체에 파라메터가 자동 저장되고
		//Model객체에도 자동 저장됨
		//Model의 속성명은 파라메터명, 값은 파라메터 값 model.addAttribute?("member", member)
		return "joinM";
	}
	
	@RequestMapping("/student/{studentId}")
	//{studentId는 경로가 아니 ㄴ값을 타나내는 변수
	//@PathVariable어노테이션으로 파라메터 변수 값으로 처리
	public String getStrudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "studentView";
	}
}
