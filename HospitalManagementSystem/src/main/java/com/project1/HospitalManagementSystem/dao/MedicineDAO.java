package com.project1.HospitalManagementSystem.dao;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.model.Medicine;

public interface MedicineDAO {
   int save(Medicine medicine);
   ArrayList<Medicine> findAll();
   int del(int id);
  
  
}
