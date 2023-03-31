package com.kyk.ex0801;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

//ConfigurableEnvironment env객체가 아닌 Environment env객체 사용
public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	private Environment env;
	private String adminId;
	private String adminPw;
	
	public AdminConnection() {
		super();
	}
	
	public AdminConnection(Environment env, String adminId, String adminPw) {
		super();
		this.env = env;
		this.adminId = adminId;
		this.adminPw = adminPw;
	}
	
	//추상메서드 정의
	@Override
	public void setEnvironment(Environment env) {
		//EnvironmentAware인터페이스의 추상메서드로 실행시 호출되는 callback메서드
		System.out.println("setEnvironment()"); 
		setEnv(env);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean인터페이스의 추상 메서드로 스프링컨테이너 객체 초기화 이후에 발생, 이때 속성값을 설정해줌
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id")); //Environment env에 있는 getProperty("속성명")으로 값을 반환
		setAdminPw(env.getProperty("admin.pw"));
	}
	
	@Override
	public void destroy() throws Exception {
		//DisposableBean의 추상메서드
		System.out.println("destroy()");
	}
	
	public Environment getEnv() {
		return env;
	}
	public String getAdminId() {
		return adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
}
