package com.kyk.ex0701;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//�����������̳� �����ֱ�
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("�����������̳� ����");
		
		ctx.load("classpath:applicationCTX.xml");
		System.out.println("�����������̳� ����");
		ctx.refresh();
		//afterPropertiesSet()�� �ڵ� ȣ���
		//@PostConstruct �ڵ� ����
		System.out.println("�����������̳� �ʱ�ȭ");
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("�����������̳� ���");
		
		ctx.close();
		//destroy()�޼��� �ڵ� ȣ��
		//@PreDestroy �ڵ� ����
		System.out.println("�Ҹ�");
	}

}
