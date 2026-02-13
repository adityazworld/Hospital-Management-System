package com.project1.HospitalManagementSystem.service;

import java.util.List;

import com.project1.HospitalManagementSystem.model.Patient;

public interface PatientService {
   void registerPatient(Patient patient);
   void viewAllPatients();
   void delete(int id);
}
