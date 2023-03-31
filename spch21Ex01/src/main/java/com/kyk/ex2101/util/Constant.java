package com.kyk.ex2101.util;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	public static JdbcTemplate template;
	//static멤버변수(클래스멤버변수)로 JVM에서 로딩시에 설정하고 종료시까지 유지(응용프로그램 전체가 공동사용)
}
