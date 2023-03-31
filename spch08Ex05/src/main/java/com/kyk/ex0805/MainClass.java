package com.kyk.ex0805;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("콘솔창에서 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		scanner.close();
		
		//java에서 어노테이션으로 설정하므로
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		//annotation을 사용할 시 load가 아니라 register(설정클래스, 설정클래스)를 사용
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip = " + info.getIpNum());
		System.out.println("port = " + info.getPortNum());
		ctx.close();
	}

}
