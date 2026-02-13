package com.project1.HospitalManagementSystem.dao;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.model.Staff;

public interface StaffDAO {
  int save(Staff staff);
  ArrayList<Staff> findAll();
 
  int delete(int id);
}

