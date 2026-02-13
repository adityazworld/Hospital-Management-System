package com.project1.HospitalManagementSystem.model;

public class Doctor {
       private int doctorId;
       private String doctorName;
       private String specilization;
       private float experience ;
       
	   public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	   public Doctor(int doctorId, String doctorName, String specilization, float experience) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specilization = specilization;
		this.experience = experience;
	}
	   public int getDoctorId() {
		   return doctorId;
	   }
	   public void setDoctorId(int doctorId) {
		   this.doctorId = doctorId;
	   }
	   public String getDoctorName() {
		   return doctorName;
	   }
	   public void setDoctorName(String doctorName) {
		   this.doctorName = doctorName;
	   }
	   public String getSpecilization() {
		   return specilization;
	   }
	   public void setSpecilization(String specilization) {
		   this.specilization = specilization;
	   }
	   public float getExperience() {
		   return experience;
	   }
	   public void setExperience(float experience) {
		   this.experience = experience;
	   }
	   @Override
	   public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specilization=" + specilization
				+ ", experience=" + experience + "]";
	   }
	   
       
       
}
