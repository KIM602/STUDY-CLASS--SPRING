package com.kyk.ex0301;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		//���� java����
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		myCalculator.add();
		*/
		//spring������ ���� ����
		//������ ���������� ��ġ�� ���ڿ��� ����
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext�� �߻�Ŭ������ IOC�����̳� �������� applicationCTX.xml�� ���� �ε��ؼ� ��ü�� �����ϴ� �������̽�
		//GenericApplicationContextsms �߻�Ŭ������ ������ Ŭ������ ���Ե� ��ü�� ����
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class); //getBean("bean�̸�", class��)
		
		myCalculator.add();
	}

}

/*
 * ������IOC�����̳� �������� xml�� src/main/resources�ؿ� �����.
 * AbstractApplicationContext��ü�� GenericXmlApplicationContext�� ����
 * (�̶� �Ķ���ͷ� xml���ϰ�θ� ���)
 * �����������̳� ��ü ����� �� getBean("���̸�", Ŭ�������ϸ�)���� ��ü�� ���� �޴´�.
 */
