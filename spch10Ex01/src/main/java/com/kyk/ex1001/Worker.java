package com.kyk.ex1001;

public class Worker {
	private String name;
	private int age;
	private String job;
	
	public Worker() {
		super();
	}

	public Worker(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	//�߰� �޼���
	public void getWorkerInfo() {
		System.out.println("�̸� : " + getName());
		System.out.println("���� : " + getAge());
		System.out.println("���� : " + getJob());
	}

}
