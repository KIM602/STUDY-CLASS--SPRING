package com.kyk.sec.constant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kyk.sec.dao.SecDao;

//공통사용요소
public class Constant {
	public static BCryptPasswordEncoder passwordEncoder;
	public static SecDao sdao;
}
