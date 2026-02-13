package com.project1.HospitalManagementSystem.dao;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.model.Patient;

public interface PatientDAO {
  int save(Patient patientData);
	
	/*--- to fetch complete course list ---*/
	ArrayList<Patient> findAll();
	
	/*--- to fetch course details based on Patient id ----*/
  boolean findById(int patientId);
  int delete(int id);
	
	
}
