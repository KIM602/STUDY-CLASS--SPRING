package com.kyk.ex0701;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//InitializingBean�� �����������̳� �ʱ�ȭ�� ���� �ʱ�ȭ���ִ� �������̽�
//DisposableBean�� �����������̳� �Ҹ�� �ڿ��� �ؼ��ϴ� �������̽�
public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	
	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void destroy() throws Exception {
		//DisposableBean�� �߻�޼���
		System.out.println("destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//InitializingBean�� �߻�޼���
		System.out.println("afterPropertiesSet()");
	}
}
