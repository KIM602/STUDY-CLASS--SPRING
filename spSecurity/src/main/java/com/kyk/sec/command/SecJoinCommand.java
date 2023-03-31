package com.kyk.sec.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.kyk.sec.constant.Constant;
import com.kyk.sec.dao.SecDao;
import com.kyk.sec.dto.JoinDto;

public class SecJoinCommand implements SecCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		//암호화 객체
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		
		//form의 입력 원소값을 추출
		String bid = request.getParameter("pid");
		String bpw = request.getParameter("ppw");
		String baddress = request.getParameter("paddress");
		String bhobby = request.getParameter("phobby");
		String bprofile = request.getParameter("pprofile");
		
		//암호화 전 bpw를 bpw_org에 저장
		String bpw_org = bpw; //bpw_org는 암호화 전 pw
		bpw = passwordEncoder.encode(bpw_org); //encode메서드로 암호화
		System.out.println(bpw + " size " + bpw.length());
		
		JoinDto dto = new JoinDto(bid, bpw, baddress, bhobby, bprofile);
		
		SecDao sdao = Constant.sdao;
		
		String result = sdao.join(dto);
		
		request.setAttribute("result", result);
	}

}
