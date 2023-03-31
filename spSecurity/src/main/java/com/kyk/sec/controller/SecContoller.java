package com.kyk.sec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyk.sec.command.SecCommand;
import com.kyk.sec.command.SecJoinCommand;
import com.kyk.sec.constant.Constant;
import com.kyk.sec.dao.SecDao;

@Controller
public class SecContoller {
		
		//SecCommand인터페이스의 객체 선언
		private SecCommand com;
		
		//암호화 처리 bean주입(공통사용요소이므로 주입 후 저장해놓고 사용)
		private BCryptPasswordEncoder passwordEncoder;
		@Autowired
		public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
			this.passwordEncoder = passwordEncoder;
			Constant.passwordEncoder = passwordEncoder;
		}
		
		//SecDao클래스 bean 주입
		private SecDao sdao;
		@Autowired
		public void setSdao(SecDao sdao) {
			this.sdao = sdao;
			Constant.sdao = sdao;
		}
		
		//회원가입 화면 처리
		@RequestMapping("/join_view")
		public String joinview() {
			return "join_view";
		}
		
		//로그인창
		@RequestMapping("/login_view")
		public String logView() {
			return "login_view";
		}
		

		//회원가입처리 요청
		@RequestMapping(value="/join", produces="application/text; charset=UTF-8") //ajax로 요청시 한글처리
		@ResponseBody //ajax로 요청이 오고 jsp아닌 일반 문자열, 객체 map, list 등으로 반환시
		public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
			System.out.println("join");
			
			com = new SecJoinCommand();
			com.execute(request, model);
			
			//setAttribute()메서드로 설정한 값을 추출
			String result = (String)request.getAttribute("result");
			System.out.println(result);
			if(result.equals("success")) {
				return "join-success";
			}
			else {
				return "join-failed";
			}
		}
}
