package com.kyk.batis01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyk.batis01.dao.ContentDao;
import com.kyk.batis01.dao.TicketTransaction;
import com.kyk.batis01.dto.ContentDto;
import com.kyk.batis01.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ContentDao dao;
	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}
	
	@Autowired //bean클래스가 property가 없는 경우에는 그냥 필드방식
	private TicketTransaction tdao;
	
	
	
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
		
		//return "writeForm";
		return "redirect:list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		dao.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		ArrayList<ContentDto> list = dao.listDao();
		model.addAttribute("list", list	);
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		ContentDto dto = dao.viewDao(request.getParameter("mId"));
		model.addAttribute("contentView", dto);
		return "contentView";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
	@RequestMapping("/buyForm")
	public String buyForm()	 {
		return "buyTicket";
	}
	
	@RequestMapping("/buyCard")
	public String buyCard(TicketDto ticketDto, HttpServletRequest request, Model model) throws Exception {
		System.out.println("buyCard");
		System.out.println("ComsumerId : " + ticketDto.getConsumerId());
		System.out.println("amount : " + ticketDto.getAmount());
		tdao.transAction(dao,ticketDto);
		model.addAttribute("ticketInfo", ticketDto);
		return "buyTicketResult";
	}
}
