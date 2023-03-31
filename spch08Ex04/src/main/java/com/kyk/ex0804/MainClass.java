package com.kyk.ex0804;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("입력해 주세요 콘솔창에서");
		Scanner scanner = new Scanner(System.in); //키보드 입력처리 객체
		String str = scanner.next(); //입력된 값
		if(str.equals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		//getEnvironment()는 ConfigurableEnvironment 객체를 반환하고 setActiveProfiles(config);는 xml의 profile이 config인 xml선택
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml"); //2개의 xml 중 선택된	 xml을 로딩
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();
	}

}
