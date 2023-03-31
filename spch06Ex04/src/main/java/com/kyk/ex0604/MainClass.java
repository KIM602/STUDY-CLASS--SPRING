package com.kyk.ex0604;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//java annotation class�� ������ bean�� �����������̳� ���� Ŭ���� ���
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1", Student.class); //ApplicationConfig���� ���� ��
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("���� : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		//xml���� ������ bean student2
		Student student2 = ctx.getBean("student2", Student.class); //ApplicationConfig���� ���� ��
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("���� : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
		
		ctx.close();
	}

}