package com.project1.HospitalManagementSystem.dao;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.model.Doctor;

public interface DoctorDAO {
   int save(Doctor doctorData);
   ArrayList<Doctor> findAll();
   boolean findById(int id);
   int delete(int id);
}
