package com.kej.ex0502;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		//Ŭ���� ���ϸ� �������̽� Ŭ���� ���ϸ��� ����ϸ� �������̽��� ������ ��� Ŭ������ bean�� ����� �� ����
		//�� pencil�� Pencil6BWithEraser
		
		pencil.use();
		ctx.close();
	
	}

}
