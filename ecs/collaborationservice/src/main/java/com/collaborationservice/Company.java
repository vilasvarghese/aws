package com.collaborationservice;


public class Company {
	private String name;
	
	private String description;
	private int numberOfEmployees;
	public Company() {
		super();
	}
	
	public Company(String name, String description, int numberOfEmployees) {
		super();
		this.name = name;
		this.description = description;
		this.numberOfEmployees = numberOfEmployees;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

}
