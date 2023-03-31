package com.kyk.jsonAjax;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
		
		return "jsonAjax";
	}
	
	@RequestMapping(value = "/stringify",produces = "application/json; charset=UTF8") //JSON으로 받을시는 application/json
	@ResponseBody //클라이언트로 반환을 JSON형식으로 문자열, Map, List, Object형으로 반환
	public HashMap<String, Object> stringify(@RequestBody Jamong jamong	) { //파라메터에 JSON으로 받을시는 @RequestBody를 사용
		System.out.println("json");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", jamong.getName());
		map.put("age", jamong.getAge());
		
		return map; //@Responsebody에 의해 map을 json으로 반환
	}
}
