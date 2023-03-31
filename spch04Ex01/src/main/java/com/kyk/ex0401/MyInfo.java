package com.kyk.ex0401;

import java.util.ArrayList;

//xml�� bean���� ����ϱ����� setter, getter�� ����
public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;
	
	public MyInfo() {
		super();
	}
	
	public MyInfo(String name, double height, double weight, ArrayList<String> hobbys, BMICalculator bmiCalculator) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.hobbys = hobbys;
		this.bmiCalculator = bmiCalculator;
	}
	
	public String getName() {
		return name;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	//setter, getter�� �ƴ� �߰��޼���
	public void getInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("Ű : " + height);
		System.out.println("������ : " + weight);
		System.out.println("��� : " + hobbys);
		
		bmiCalculation();
	}

	private void bmiCalculation() {
		bmiCalculator.bmicalculation(weight, height);
	}
}
