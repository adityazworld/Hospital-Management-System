package com.project1.HospitalManagementSystem.service.impl;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.DoctorDAO;
import com.project1.HospitalManagementSystem.dao.MedicineDAO;
import com.project1.HospitalManagementSystem.dao.impl.DoctorDAOImpl;
import com.project1.HospitalManagementSystem.dao.impl.MedicineDAOImpl;
import com.project1.HospitalManagementSystem.model.Doctor;
import com.project1.HospitalManagementSystem.model.Medicine;
import com.project1.HospitalManagementSystem.service.MedicineService;


public class MedicineServiceImpl implements MedicineService{

	MedicineDAO medicineDao;
	public MedicineServiceImpl() {
		medicineDao=new MedicineDAOImpl();
	}

	@Override
	public void addMedicine(Medicine medicine) {
		if(medicine==null) {
			System.out.println(" Data is Empty!!");
		}
		else {
			int rows=medicineDao.save(medicine);
			if(rows>0) {
				System.out.println("Doctor Inserted Successfully!!");
			}
			else {
				System.out.println("Failed To insert");
			}
		}
		
	}

	@Override
	public void viewAllMedicine() {
		ArrayList<Medicine> medicineList=medicineDao.findAll();
		if(medicineList.size()>0) {
			System.out.println("Medicine");
			System.out.println("+--------+----------------+----------+----------+-----------+---------------------+-------------+");
			System.out.println("| Med_id | Medicine_Name  | Category | Quantity | Price(Rs) |   Added_on          | Expiry_date |");
			System.out.println("+--------+----------------+----------+----------+-----------+---------------------+-------------+");
			for(Medicine m:medicineList) {
				int id=m.getId();
				String name=m.getMedicineName();
				String category=m.getCategory();
				int quantity=m.getQuantity();
				double price=m.getPrice();
				String added_on=m.getDateAddedOn();
				String expiry_date=m.getExpiryDate(); 
				System.out.printf("|%-8s|%-16s|%-10s|%-10s|%-11s|%-21s|%-13s|\n",id,name,category,quantity,price,added_on,expiry_date);
				System.out.println("+--------+----------------+----------+----------+-----------+---------------------+-------------+");
			}
		}
		else {
			System.out.println("No Data found");
		}
	}
public void delete(int id) {
		
		int rows=medicineDao.del(id);
		if(rows>0) {
			System.out.println("Deletion Successfull!!");
		}
		else {
			System.out.println("Failed To Delete");
		}
	}

}
