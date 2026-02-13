package com.project1.HospitalManagementSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.project1.HospitalManagementSystem.dao.PatientDAO;
import com.project1.HospitalManagementSystem.dao.impl.PatientDAOImp;
import com.project1.HospitalManagementSystem.model.Patient;
import com.project1.HospitalManagementSystem.service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDAO patientDao;
	public PatientServiceImpl() {
		patientDao=new PatientDAOImp();
	}
	@Override
	public void registerPatient(Patient patient) {
		if(patient==null) {
		  System.out.println("Patient Data is Empty");
		}
		else {
			int rows=patientDao.save(patient);
			if(rows>0) {
				System.out.println("Patient Data Inserted Succesfully !!");
			}
			else {
				System.out.println("Failed");
			}
		}
	}
	@Override
	public void viewAllPatients() {
		ArrayList<Patient> patientList=patientDao.findAll();
		if(patientList.size()>0) {
			System.out.println("Patients:");
			  System.out.println("+------------+-----------------+--------+--------+-----------------+");
			  System.out.println("| Patient Id | Name            | Age    | Gender |  Disease");
			  System.out.println("+------------+-----------------+--------+--------+-----------------+");
			  for(Patient p:patientList) {
				  int id=p.getPatientId();
				  String name=p.getName();
				  int age=p.getAge();
				  String gender=p.getGender();
				  String disease=p.getDisease();
				  System.out.printf("|%-12s|%-17s|%-8s|%-8s|%-17s|\n",id,name,age,gender,disease);
				  System.out.println("+------------+-----------------+--------+--------+-----------------+");
		}
			  }
		else {
			System.out.println("No Patient Data Found");
		}
		
	}
	public boolean getById( int id ) {
		return patientDao.findById(id);
	}
	@Override
	public void delete(int id) {
		
		int rows=patientDao.delete( id);
		if(rows>0) {
			System.out.println("Deletion Successfull!!");
		}
		else {
			System.out.println("Failed To Delete");
		}
	}
	

}
