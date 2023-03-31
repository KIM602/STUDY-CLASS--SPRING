package com.osm.sec.constant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.osm.sec.dao.SecDao;

// 공통사용 요소 저장 클래스
public class Constant {
	public static BCryptPasswordEncoder passwordEncoder;
	public static SecDao sdao;
}
