package com.kyk.ex0801;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

//ConfigurableEnvironment env객체가 아닌 Environment env객체 사용
//단, MutablePropertySources에서 값을 저장한 뒤에 가능
public class MainClass {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		//ConfigurableApplicationContext은 인터페이스로 환경변수 설정시 사용하는 스프링컨테이너 객체로 환경변수 구성용 객체를 얻어내는 메서드 제공
		ConfigurableEnvironment env = ctx.getEnvironment(); //환경변수 구성 객체를 얻어냄
		
		MutablePropertySources propertySources = env.getPropertySources();
		//MutablePropertySources는 속성들을 조작하는 인터페이스 객체
		
		try {
			//bean을 통하지 않고(빈 클래스의 get메서드 없이) 바로 .properties에 있는 속성을 가져옴
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			//ResourcePropertySource는 속성정보를 가진 자원을 처리하는 클래스
			//admin.properties라는 속성용 파일을 객체화하여 propertySources 마지막에 추가
			//ConfigurableEnvironment env객체의 getProperty()메서드 사용하여 속성값 반환
			System.out.println(env.getProperty("admin.id"));
			//getProperty("property이름")으로 속성값을 가져옴
			System.out.println(env.getProperty("admin.pw"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//xml사용을 위해 형변환
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		//ConfigurableApplicationContext객체를 xml 사용 객체인 GenericXmlApplicationContext로 형변환
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		gCtx.close();
		ctx.close();
	}

}
