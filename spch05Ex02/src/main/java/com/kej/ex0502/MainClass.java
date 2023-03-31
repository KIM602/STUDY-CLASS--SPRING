package com.kej.ex0502;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		//클래스 파일명에 인터페이스 클래스 파일명을 사용하면 인터페이스를 구현한 모든 클래스의 bean을 사용할 수 있음
		//빈 pencil은 Pencil6BWithEraser
		
		pencil.use();
		ctx.close();
	
	}

}
