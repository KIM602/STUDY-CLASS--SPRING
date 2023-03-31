package com.osm.sec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osm.sec.command.SecCommand;
import com.osm.sec.command.SecJoinCommand;
import com.osm.sec.constant.Constant;
import com.osm.sec.dao.SecDao;

@Controller
public class SecController {
	
	
	//SecCommand인터페이스의 객체 선언
	private SecCommand com;
	
	// 암호화 처리 bean주입(공통 사용 요소이므로 주입후 저장해놓고 사용)
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		Constant.passwordEncoder = passwordEncoder;
	}
	
	// SecDao클래스 bean 주입
	private SecDao sdao;
	@Autowired
	public void setSdao(SecDao sdao) {
		this.sdao = sdao;
		Constant.sdao = sdao;
	}
	// 회원가입 화면 처리
	@RequestMapping("/join_view")
	public String join_view() {
		return "joinView";
	}
	//로그인 창
	@RequestMapping("/login_view")
	public String logView() {
		return "login_view";
	}
	// 회원가입처리 요청
	@RequestMapping(value="/join",produces = "application/text; charset=UTF-8") // ajax로 요청시 한글 처리
	@ResponseBody // ajax로 요청이 오고 jsp아닌 일반 문자열,객체 map,list등으로 반환시 
	public String join(HttpServletRequest request, HttpServletResponse response,Model model){
		System.out.println("join시작");
		com = new SecJoinCommand();
		com.execute(request, model);
		// setAttribute()메서드로 설정한 값을 가져오기위해 getAttribute() 사용
		String result = (String)request.getAttribute("result");
		System.out.println(result);
		if(result.equals("success")) {
			return "join-success";
		}
		else {
			return "join-failed";
		}
		
	}
	
	@RequestMapping("/main") // 로그인 성공시 요청 경로 // security에서 설정함
	public String main() {
		return "mainView";
	}
	
	@RequestMapping("/processLogin")
	public ModelAndView processLogin(
			@RequestParam(value="log",required = false) String log,
			@RequestParam(value="error",required = false) String error,
			@RequestParam(value="logout",required = false) String logout){
		//@RequestParam은 요청경로 뒤의 ?이후의 쿼리의 이름 ?log=1&logout=1&error=1 이런식임
		// required = false는 필요치 않으면 없어도 되는 파라메터
		ModelAndView model =new ModelAndView();
		if(log != null && log !="") {
			model.addObject("log","before login!");
		}
		if(error !=null && error != "") {
			model.addObject("error","패스워드 또는 유저네임이 다름");
		}
		if(logout !=null && logout != "") {
			model.addObject("logout","로그아웃함");
		}
		model.setViewName("login_view"); //jsp 설정
		return model;
	}
	@RequestMapping("/logoutView")
	public String logoutView() {
		return "logoutView";
	}
}
