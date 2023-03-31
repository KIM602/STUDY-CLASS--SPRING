package com.kyk.ex0803;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	//properties파일을 사용하기 위해서는 @Value("${프로퍼티스 파일의 키값}")어노테이션을 사용하고
	//그 밑에 그 값을 저장할 멤버변수를 선언
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;
	
	//properties파일의 위치를 등록하여 @Value를 이용하여  properties의 속성을 멤버변수에 설정해줌
	//xml에서 <context:property-placeholder location="classpath:admin.properties, classpath:sub_admin.properties"/> 역할
	//properties파일들을 등록 해주는 메서드로 callback
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2]; //properties파일의 갯수만큼의 크기를 갖는 배열
		
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	//Value로 만들어진 속성값을 bean이름이 adimConfig인 AdminConnection객체에 설정
	public AdminConnection adminConfig() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
