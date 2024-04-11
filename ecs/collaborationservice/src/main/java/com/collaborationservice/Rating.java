package com.collaborationservice;

public class Rating {

	private String id;
	private int rating;

	public Rating(String id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}

	public Rating() {
		super();
	}
	
	public String getName() {
		return id;
	}
	public void setName(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
