package com.kyk.ex0805;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("�ܼ�â���� �Է��ϼ���.");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		if(str.equals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		scanner.close();
		
		//java���� ������̼����� �����ϹǷ�
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		//annotation�� ����� �� load�� �ƴ϶� register(����Ŭ����, ����Ŭ����)�� ���
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip = " + info.getIpNum());
		System.out.println("port = " + info.getPortNum());
		ctx.close();
	}

}
