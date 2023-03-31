package com.kyk.jsonAjaxList;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		return "ajaxJsonList";
	}
	
	@RequestMapping(value = "/ajaxList", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public Object ajaxList(@RequestBody Jamong jamong) {
		ArrayList<String> arrList = new ArrayList<String>();
		for(int i = 0 ; i <5 ; i ++) {
			arrList.add(jamong.getName() + i);
		}
		
		return arrList; //List형식의 JSON문자열로 반환
	}
	
	@RequestMapping(value="/ajaxObj", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Jamong ajaxObj(@RequestBody Jamong jamong) {
		return jamong; //객체 형식으로 반환하는 경우
	}
}
