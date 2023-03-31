package com.kyk.ex0301;

//IOC�����̳ʿ��� bean���� ���� Ŭ������ �����ڿ� setter�޼��尡 �־�� ��
public class MyCalculator {
	//��� ����
	Calculator calculator; //�ܺ� Ŭ���� ��ü
	private int firstNum; //�⺻�� ��� ����
	private int secondNum; //�⺻�� ��� ����
	
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
	
	//�߰� �ʿ� �޼���
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
}