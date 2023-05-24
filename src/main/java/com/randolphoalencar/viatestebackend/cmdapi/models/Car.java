package com.randolphoalencar.viatestebackend.cmdapi.models;

public class Car implements Comparable<Car>{
	
	private String name;
	private Integer fillTime;
	
	
	public Car() {

	}
	
	public Car(String name, Integer fillTime) {
		this.name = name;
		this.fillTime = fillTime;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFillTime() {
		return fillTime;
	}
	public void setFillTime(Integer fillTime) {
		this.fillTime = fillTime;
	}
	
	@Override
	public String toString() {
		return name + ", Tempo de abastecimento: " + fillTime + " segs";
	}

	@Override
	public int compareTo(Car c) {
		return fillTime.compareTo(c.fillTime);
	}
	
	
}
