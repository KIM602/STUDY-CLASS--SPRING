package com.kyk.ex0301;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		//기존 java형식
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		myCalculator.add();
		*/
		//spring주입을 통한 구현
		//스프링 설정파일의 위치를 문자열로 지정
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext는 추상클래스로 IOC컨테이너 설정파일 applicationCTX.xml의 내용 로딩해서 객체를 생성하는 인터페이스
		//GenericApplicationContextsms 추상클래스를 구현한 클래스로 주입될 객체를 만듬
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class); //getBean("bean이름", class명)
		
		myCalculator.add();
	}

}

/*
 * 스프링IOC컨테이너 설정파일 xml을 src/main/resources밑에 만든다.
 * AbstractApplicationContext객체를 GenericXmlApplicationContext로 만듬
 * (이때 파라메터로 xml파일경로를 사용)
 * 스프링컨테이너 객체 얻어진 후 getBean("빈이름", 클래스파일명)으로 객체를 주입 받는다.
 */
