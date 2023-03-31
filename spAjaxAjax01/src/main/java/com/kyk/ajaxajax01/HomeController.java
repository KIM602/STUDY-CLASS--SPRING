package com.kyk.ajaxajax01;

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
		
		return "ajax";
	}
	
	@RequestMapping(value="/data", produces = "application/text; charset=UTF8")
	//반환을 jsp로 할 때 @ResponseBody없음
	public String data(HttpServletRequest request, HttpServletResponse response, Model model) {
		//ajax시 반환은 data.jsp임
		return "data"; //ajax로 반환될시는 jsp는 html로 반환해서 감
	}
	
	//일반 방식(form, a로 요청)
	@RequestMapping("/form1")
	public String form1() {
		return "form1";
	}
}
