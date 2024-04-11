package com.collaborationservice;

public class EmployeeRatingCatalog {

	private Employee employee;
	private Rating rating;
	public EmployeeRatingCatalog() {
		super();
	}
	
	public EmployeeRatingCatalog(Employee employee, Rating rating) {
		super();
		this.employee = employee;
		this.rating = rating;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public void print() {
		System.out.println(employee.toString());
		System.out.println(rating.toString());
			
	}

}
