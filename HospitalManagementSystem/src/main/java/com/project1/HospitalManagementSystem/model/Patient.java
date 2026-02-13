package com.project1.HospitalManagementSystem.model;

public class Patient {
	private int patientId;
  private String name;
 private int age;
 private String gender;
 private String disease;
 
 public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
 public Patient(int patientId, String name, int age, String gender, String disease) {
	super();
	this.patientId = patientId;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.disease = disease;
}
 public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
 public String getName() {
	return name;
 }
 public void setName(String name) {
	this.name = name;
 }
 public int getAge() {
	return age;
 }
 public void setAge(int age) {
	this.age = age;
 }
 public String getGender() {
	return gender;
 }
 public void setGender(String gender) {
	this.gender = gender;
 }
 public String getDisease() {
	return disease;
 }
 public void setDisease(String disease) {
	this.disease = disease;
 }
 @Override
 public String toString() {
	return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", disease="
			+ disease + "]";
 }

 
}
