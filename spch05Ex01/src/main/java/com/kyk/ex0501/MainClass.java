package com.kyk.ex0501;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		//StudentInfo는 Student를 사용하므로 의존하고 있음(student1 빈을 사용하고 있음)
		studentInfo.getStudentInfo();
		
		//student2 bean을 student2객체로 사용
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2); //studentInfo객체에서 사용하는 객체를 student2로 설정
		studentInfo.getStudentInfo(); //student2 bean의 값을 출력
	}

}
