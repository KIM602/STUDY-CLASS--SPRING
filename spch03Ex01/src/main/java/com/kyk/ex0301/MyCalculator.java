package com.kyk.ex0301;

//IOC컨테이너에서 bean으로 사용될 클래스로 생성자와 setter메서드가 있어야 함
public class MyCalculator {
	//멤버 변수
	Calculator calculator; //외부 클래스 객체
	private int firstNum; //기본형 멤버 변수
	private int secondNum; //기본형 멤버 변수
	
	public MyCalculator() {
		super();
	}

	public MyCalculator(Calculator calculator, int firstNum, int secondNum) {
		super();
		this.calculator = calculator;
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	//추가 필요 메서드
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
}