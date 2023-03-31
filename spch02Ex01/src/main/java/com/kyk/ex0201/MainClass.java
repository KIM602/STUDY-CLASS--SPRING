package com.kyk.ex0201;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("main¸Þ¼­µå");
		Calculation calculation = new Calculation();
		
		calculation.setFirstNum(10);
		calculation.setSecondNum(2);
		
		calculation.addition();
	}

}
