package com.project1.HospitalManagementSystem.model;

public class Staff {
   private int id;
   private String staffName;
   private String gender;
   private String role;
   private double salary;
   public Staff() {
	super();
	// TODO Auto-generated constructor stub
   }
   public Staff( String staffName, String gender, String role, double salary) {
	super();
	this.staffName = staffName;
	this.gender = gender;
	this.role = role;
	this.salary = salary;
   }
   public void setId(int id) {
	this.id = id;
   }
   public int getId() {
	   return id;
   }
   public String getStaffName() {
	return staffName;
   }
   public void setStaffName(String staffName) {
	this.staffName = staffName;
   }
   public String getGender() {
	return gender;
   }
   public void setGender(String gender) {
	this.gender = gender;
   }
   public String getRole() {
	return role;
   }
   public void setRole(String role) {
	this.role = role;
   }
   public double getSalary() {
	return salary;
   }
   public void setSalary(double salary) {
	this.salary = salary;
   }
   @Override
   public String toString() {
	return "Staff [id=" + id + ", staffName=" + staffName + ", gender=" + gender + ", role=" + role + ", salary="
			+ salary + "]";
   }
   
}
