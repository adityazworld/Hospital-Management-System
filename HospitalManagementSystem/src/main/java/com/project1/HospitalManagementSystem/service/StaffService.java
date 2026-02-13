package com.project1.HospitalManagementSystem.service;

import com.project1.HospitalManagementSystem.model.Staff;

public interface StaffService {
    void registerStaff(Staff staff);
    void findAllStaff();
   
    public void delete(int id);
}
