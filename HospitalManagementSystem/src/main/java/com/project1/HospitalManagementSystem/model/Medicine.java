package com.project1.HospitalManagementSystem.model;

public class Medicine {
	private int id;
	private String medicineName;
	private String Category;
	private int quantity;
	private double price;
	private String expiryDate;
	private String dateAddedOn;
	
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine( String medicineName, String category, int quantity, double price, String expiryDate) {
		super();
		this.medicineName = medicineName;
		Category = category;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setDateAddedOn(String dateAddedOn) {
		this.dateAddedOn = dateAddedOn;
	}
	public String getDateAddedOn() {
		return dateAddedOn;
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", medicineName=" + medicineName + ", Category=" + Category + ", quantity="
				+ quantity + ", price=" + price + ", expiryDate=" + expiryDate + ", dateAddedOn=" + dateAddedOn + "]";
	}
	
	
	

}
