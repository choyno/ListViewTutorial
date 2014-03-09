package com.example.listviewtutorial;

public class Car {

	private int icon;
	private int year;
	private String name;
	private String brand;
		
	
	public Car(int icon, int year, String name, String brand){
		this.icon = icon;
		this.year = year;
		this.name = name;
		this.brand = brand;
		
	}
	
	public int getIcon(){
		return icon;
	}
	 
	public int getYear(){
		return year;
	}
	 
	public String getName(){
		return name;
	}
	 
	public String getBrand(){
		return brand;
	}
	  
}
