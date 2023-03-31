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
		
		//SecCommand�������̽��� ��ü ����
		private SecCommand com;
		
		//��ȣȭ ó�� bean����(���������̹Ƿ� ���� �� �����س��� ���)
		private BCryptPasswordEncoder passwordEncoder;
		@Autowired
		public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
			this.passwordEncoder = passwordEncoder;
			Constant.passwordEncoder = passwordEncoder;
		}
		
		//SecDaoŬ���� bean ����
		private SecDao sdao;
		@Autowired
		public void setSdao(SecDao sdao) {
			this.sdao = sdao;
			Constant.sdao = sdao;
		}
		
		//ȸ������ ȭ�� ó��
		@RequestMapping("/join_view")
		public String joinview() {
			return "join_view";
		}
		
		//�α���â
		@RequestMapping("/login_view")
		public String logView() {
			return "login_view";
		}
		

		//ȸ������ó�� ��û
		@RequestMapping(value="/join", produces="application/text; charset=UTF-8") //ajax�� ��û�� �ѱ�ó��
		@ResponseBody //ajax�� ��û�� ���� jsp�ƴ� �Ϲ� ���ڿ�, ��ü map, list ������ ��ȯ��
		public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
			System.out.println("join");
			
			com = new SecJoinCommand();
			com.execute(request, model);
			
			//setAttribute()�޼���� ������ ���� ����
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
