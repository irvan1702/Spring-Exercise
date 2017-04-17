package com.example;

public class Employee {
	String name;
	String gender;

	public Employee(String name,String gender) {
		this.name=name;
		this.gender=gender;
	}
	
	public Employee(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
