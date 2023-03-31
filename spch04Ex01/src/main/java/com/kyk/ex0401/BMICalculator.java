package com.kyk.ex0401;

public class BMICalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;
	
	public BMICalculator() {
		super();
	}
	
	public BMICalculator(double lowWeight, double normal, double overWeight, double obesity) {
		super();
		this.lowWeight = lowWeight;
		this.normal = normal;
		this.overWeight = overWeight;
		this.obesity = obesity;
	}
	
	public double getLowWeight() {
		return lowWeight;
	}
	public double getNormal() {
		return normal;
	}
	public double getOverWeight() {
		return overWeight;
	}
	public double getObesity() {
		return obesity;
	}
	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	
	//setter, getter �ƴ� �޼���
	public void bmicalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);
		System.out.println("BMI ���� : " + (int)result);
		if(result > obesity)
			System.out.println("�� �Դϴ�.");
		else if(result > overWeight)
			System.out.println("��ü�� �Դϴ�.");
		else if(result > normal)
			System.out.println("���� �Դϴ�.");
		else
			System.out.println("��ü�� �Դϴ�.");
	}
}
