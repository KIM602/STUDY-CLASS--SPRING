package com.kyk.ajaxajax02;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
		
		return "ajax";
	}
	
	@RequestMapping(value = "/requestObject", produces = "application/text; charset=UTF8")
	@ResponseBody
	public String simpleWithObject(Jamong jamong) {
		return jamong.getName() + " and " + jamong.getAge();
	}
	
	@RequestMapping(value = "/format", produces = "application/text; charset=UTF8")
	@ResponseBody
	public String format(Jamong jamong) {
		return jamong.getName() + " and " + jamong.getAge();
	}
}
