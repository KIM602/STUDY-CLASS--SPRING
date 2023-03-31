package com.kyk.ex0801;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

//ConfigurableEnvironment env��ü�� �ƴ� Environment env��ü ���
//��, MutablePropertySources���� ���� ������ �ڿ� ����
public class MainClass {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		//ConfigurableApplicationContext�� �������̽��� ȯ�溯�� ������ ����ϴ� �����������̳� ��ü�� ȯ�溯�� ������ ��ü�� ���� �޼��� ����
		ConfigurableEnvironment env = ctx.getEnvironment(); //ȯ�溯�� ���� ��ü�� ��
		
		MutablePropertySources propertySources = env.getPropertySources();
		//MutablePropertySources�� �Ӽ����� �����ϴ� �������̽� ��ü
		
		try {
			//bean�� ������ �ʰ�(�� Ŭ������ get�޼��� ����) �ٷ� .properties�� �ִ� �Ӽ��� ������
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			//ResourcePropertySource�� �Ӽ������� ���� �ڿ��� ó���ϴ� Ŭ����
			//admin.properties��� �Ӽ��� ������ ��üȭ�Ͽ� propertySources �������� �߰�
			//ConfigurableEnvironment env��ü�� getProperty()�޼��� ����Ͽ� �Ӽ��� ��ȯ
			System.out.println(env.getProperty("admin.id"));
			//getProperty("property�̸�")���� �Ӽ����� ������
			System.out.println(env.getProperty("admin.pw"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//xml����� ���� ����ȯ
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		//ConfigurableApplicationContext��ü�� xml ��� ��ü�� GenericXmlApplicationContext�� ����ȯ
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
