package com.kyk.ex0801;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

//ConfigurableEnvironment env��ü�� �ƴ� Environment env��ü ���
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
	
	//�߻�޼��� ����
	@Override
	public void setEnvironment(Environment env) {
		//EnvironmentAware�������̽��� �߻�޼���� ����� ȣ��Ǵ� callback�޼���
		System.out.println("setEnvironment()"); 
		setEnv(env);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean�������̽��� �߻� �޼���� �����������̳� ��ü �ʱ�ȭ ���Ŀ� �߻�, �̶� �Ӽ����� ��������
		System.out.println("afterPropertiesSet()");
		setAdminId(env.getProperty("admin.id")); //Environment env�� �ִ� getProperty("�Ӽ���")���� ���� ��ȯ
		setAdminPw(env.getProperty("admin.pw"));
	}
	
	@Override
	public void destroy() throws Exception {
		//DisposableBean�� �߻�޼���
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
