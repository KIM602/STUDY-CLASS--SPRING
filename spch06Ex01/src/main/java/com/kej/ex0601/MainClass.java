package com.kej.ex0601;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//�������� xml�� �ΰ��� ����
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX2.xml";
		
		//������ �Ķ���ͷ� 2�� ��� ���ڿ��� ����ϸ� �ΰ��� �����ϴ� ������ �����̳ʰ� ����
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(configLocation1,configLocation2);
		
		//GenericXmlApplicationContext.GenericXmlApplicationContext(String... resourceLocations)
		//�Ķ���Ͱ� String... resourceLpcationsó�� �������� �ڿ� ...�� ���� ������ �Ķ���ͷ� �Ķ���ͼ��� ���Ƿ� ���(vararg)
		Student student1 = ctx.getBean("student1",Student.class);
		//���� student1�� �ڹٿ����� ��ü���̰� ���� student1�� xml������ bean id��
		System.out.println(student1.getName()); //ȫ�浿
		System.out.println(student1.getHobbys()); //����,�丮
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1",StudentInfo.class);
		//StudentInfo bean�� student1 bean���
		Student student2 = studentInfo.getStudent();//student1 bean�� ����� ��ü�̹Ƿ� student2�� student1��ü
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3",Student.class);
		System.out.println(student3.getName()); //ȫ����
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}
		else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family",Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
	}

}
