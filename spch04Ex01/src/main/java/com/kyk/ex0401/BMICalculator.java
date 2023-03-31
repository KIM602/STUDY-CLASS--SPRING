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
	
	//setter, getter 아닌 메서드
	public void bmicalculation(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);
		System.out.println("BMI 지수 : " + (int)result);
		if(result > obesity)
			System.out.println("비만 입니다.");
		else if(result > overWeight)
			System.out.println("과체중 입니다.");
		else if(result > normal)
			System.out.println("정상 입니다.");
		else
			System.out.println("저체중 입니다.");
	}
}
