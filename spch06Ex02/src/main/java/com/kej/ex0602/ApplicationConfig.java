package com.kej.ex0602;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//bean�� �����ϴ� javaŬ����

@Configuration
//@Configuration������̼��� ApplicationConfigŬ������ ������ ���� ���� Ŭ�������� ��Ÿ����.
public class ApplicationConfig {
	@Bean
	//@Bean������̼��� �������� bean�� �����ϴ� ������̼� 
	public Student student1() {
		//����Ÿ���� bean�� Ŭ������
		//�޼����� �̸��� bean�̸�
		ArrayList<String> hobbys = new ArrayList<String>();
		
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿", 20, hobbys);
		
		student.setHeight(180);
		student.setWeight(80);
		
		return student;//bean student1����
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		
		hobbys.add("����");
		hobbys.add("����");
		
		Student student = new Student("ȫ����", 20, hobbys); //�����ڷ� �Ӽ��� ����
		
		student.setHeight(160);
		student.setWeight(50);
		
		return student; //bean student2 ����
	}
}
