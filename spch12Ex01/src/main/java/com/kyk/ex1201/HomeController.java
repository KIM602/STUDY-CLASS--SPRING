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
@Controller //�����ѷ� ���������� ��Ÿ���� ������̼�
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping������̼��� ��û��θ� ó���ϴ� ������̼�
	//method�� ��û���, value�� ��û���
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //home�� /WEB-INF/views/home.jsp�� ��Ÿ��
	}
	
	@RequestMapping("/board/view") //��θ� ó���� value, method�� �ʿ� ������ method�� �ڵ� �Ǻ�
	public String view() {
		return "board/view"; //views/board/veiw.jsp
	}
	@RequestMapping("board/content")
		public String content(Model model) {
			//org.sprintframework.ui.ModelŬ������ �����͸� ó���ϴ� �������� Ŭ����
			//servlet�� requestó�� ���
			//�Ķ������ Model��ü�� DispatcherServlet���� Model��ü�� �����Ͽ� ����
			model.addAttribute("id", 30); //model��ü�� �Ӽ� �߰�, ���� object
			return "board/content";
		}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() {
		//Model�� View�� ������ Ŭ����
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30); //�Ӽ� id�߰�, ���� object(�⺻������ ��ü���� ����)
		mv.setViewName("boad/reply"); //view����
		
		return mv;
	}
}

