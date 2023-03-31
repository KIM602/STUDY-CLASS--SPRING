package com.kyk.ex0201;

public class Calculation {
	private int firstNum;
	private int secondNum;
	
	public int getFirstNum() {
		return firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void addition() {
		System.out.println("addition()");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " +secondNum + "=" + result);
	}
}
