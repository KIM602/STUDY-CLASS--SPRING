package com.kyk.ex2201;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyk.ex2201.dao.TPTicketDao;
import com.kyk.ex2201.dao.TRTicketDao;
import com.kyk.ex2201.dao.TicketDao;
import com.kyk.ex2201.dto.TicketDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private TicketDao dao;
	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}
	
	private TRTicketDao trdao;
	@Autowired
	public void setTrdao(TRTicketDao trdao) {
		this.trdao = trdao;
	}
	
	private TPTicketDao tpdao;
	@Autowired
	public void setTpdao(TPTicketDao tpdao) {
		this.tpdao = tpdao;
	}
	
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
		
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_card")
	public String buy_card(TicketDto ticketDto, Model model) {
		System.out.println("buy_card");
		//파라메터로 dto사용시 자동 dto객체 생성
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		dao.buyTicket(ticketDto); //set메서드를 이용한 Autowired로 주입
		model.addAttribute("ticketInfo",ticketDto);
		return "buy_ticket_end";
	}
	
	@RequestMapping("/tr_buy_card")
	public String tr_buy_card(TicketDto ticketDto, Model model) {
		System.out.println("tr_buy_card");
		//파라메터로 dto사용시 자동 dto객체 생성
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		trdao.trbuyTicket(ticketDto);
		model.addAttribute("ticketInfo",ticketDto);
		return "buy_ticket_end";
	}

	@RequestMapping("/tp_buy_card")
	public String tp_buy_card(TicketDto ticketDto, Model model) {
		System.out.println("tr_buy_card");
		//파라메터로 dto사용시 자동 dto객체 생성
		System.out.println("ticketDto : " + ticketDto.getConsumerId());
		System.out.println("ticketDto : " + ticketDto.getAmount());
		
		tpdao.tpbuyTicket(ticketDto);
		model.addAttribute("ticketInfo",ticketDto);
		return "buy_ticket_end";
	}

}
