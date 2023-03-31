package com.kyk.ex1201;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //컨르롤러 페이지임을 나타내는 어노테이션
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping어노테이션은 요청경로를 처리하는 어노테이션
	//method는 요청방식, value에 요청경로
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //home은 /WEB-INF/views/home.jsp를 나타냄
	}
	
	@RequestMapping("/board/view") //경로만 처리시 value, method가 필요 없으며 method는 자동 판별
	public String view() {
		return "board/view"; //views/board/veiw.jsp
	}
	@RequestMapping("board/content")
		public String content(Model model) {
			//org.sprintframework.ui.Model클래스는 데이터를 처리하는 스프링의 클래스
			//servlet의 request처럼 사용
			//파라메터의 Model객체는 DispatcherServlet에서 Model객체는 생성하여 전달
			model.addAttribute("id", 30); //model객체에 속성 추가, 값은 object
			return "board/content";
		}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		//Model과 View를 결합한 클래스
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30); //속성 id추가, 값은 object(기본형부터 객체까지 가능)
		mv.setViewName("boad/reply"); //view설정
		
		return mv;
	}
}

