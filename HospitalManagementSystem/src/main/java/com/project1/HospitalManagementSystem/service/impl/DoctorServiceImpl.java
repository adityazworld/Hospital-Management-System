package com.project1.HospitalManagementSystem.service.impl;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.DoctorDAO;
import com.project1.HospitalManagementSystem.dao.impl.DoctorDAOImpl;
import com.project1.HospitalManagementSystem.model.Doctor;
import com.project1.HospitalManagementSystem.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	DoctorDAO doctorDao;
	public DoctorServiceImpl() {
		doctorDao=new DoctorDAOImpl();
	}

	@Override
	public void registerDocotor(Doctor doctor) {
		if(doctor==null) {
			System.out.println("Doctor Data is Empty!!");
		}
		else {
			int rows=doctorDao.save(doctor);
			if(rows>0) {
				System.out.println("Doctor Inserted Successfully!!");
			}
			else {
				System.out.println("Failed To insert");
			}
		}
		
	}

	@Override
	public void viewAllDoctor() {
		ArrayList<Doctor> doctorList=doctorDao.findAll();
		if(doctorList.size()>0) {
			 System.out.println("Doctors:");
			  System.out.println("+------------+-----------------+-----------------+------------+");
			  System.out.println("| Doctor Id  | Name            | Specilization   | Experience");
			  System.out.println("+------------+-----------------+-----------------+------------+");
			  for(Doctor d:doctorList) {
				  int id=d.getDoctorId();
				  String name=d.getDoctorName();
				  String specilization=d.getSpecilization();
				  float experience=d.getExperience();
				  System.out.printf("| %-11s| %-15s | %-15s |%-11s|\n",id,name,specilization,experience);
				  System.out.println("+------------+-----------------+-----------------+------------+");
			  }
		}
		else {
			System.out.println("No Data found");
		}
	}
	public boolean getById(int id) {
		return doctorDao.findById(id);
	}
public void delete(int id) {
		
		int rows=doctorDao.delete( id);
		if(rows>0) {
			System.out.println("Deletion Successfull!!");
		}
		else {
			System.out.println("Failed To Delete");
		}
	}

}
