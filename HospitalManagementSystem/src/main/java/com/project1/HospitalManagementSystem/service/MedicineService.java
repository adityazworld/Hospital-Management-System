package com.project1.HospitalManagementSystem.service;

import com.project1.HospitalManagementSystem.model.Medicine;

public interface MedicineService {
    void addMedicine(Medicine medicine);
    void viewAllMedicine();
    void delete(int id);
}
