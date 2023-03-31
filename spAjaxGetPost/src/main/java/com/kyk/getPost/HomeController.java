package com.kyk.getPost;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		return "getPost";
	}
	
	@RequestMapping(value="ajaxGet", produces="application/text;charset=UTF8")
	//produces속성은 ajax한글 처리
	@ResponseBody //반환시 jsp파일이 아닌 일반 문자열을 반환시에 사용
	public String ajaxGet(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "get method 성공";
		//응답으로 보내는 문자열, $.get()의 롤백 함수의 data로 전달
	}
	
	@RequestMapping(value="ajaxPost", produces="application/text;charset=UTF8")
	@ResponseBody
	public String ajaxPost(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("city"));
		return "post method 성공";
	}
}
