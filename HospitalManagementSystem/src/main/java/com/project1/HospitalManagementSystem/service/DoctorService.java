package com.project1.HospitalManagementSystem.service;

import com.project1.HospitalManagementSystem.model.Doctor;

public interface DoctorService {
	void registerDocotor(Doctor docotor);
	void viewAllDoctor();
	boolean getById(int id);
	void delete(int id);
}
