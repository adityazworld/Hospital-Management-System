package com.project1.HospitalManagementSystem.controller;

import java.util.Scanner;

import com.project1.HospitalManagementSystem.model.Patient;
import com.project1.HospitalManagementSystem.service.PatientService;
import com.project1.HospitalManagementSystem.service.impl.PatientServiceImpl;

public class PatientController {
	private PatientServiceImpl patientService;
	public PatientController() {
		patientService=new PatientServiceImpl();
	}
	public void patientRegisterUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Patient Id");
		int patientId=sc.nextInt();
		
		System.out.print("Enter Patient Name : ");
		String patientName = sc.next();
		sc.nextLine();
		System.out.print("Enter Age : ");
		int age= sc.nextInt();
		System.out.print("Enter Gender(M/F) : ");
		String gender = sc.next();
		System.out.print("Enter Disease : ");
		String disease = sc.next();
		
		
		//calling register method
		patientService.registerPatient(new Patient(patientId,patientName,age,gender,disease));
	}
	public void viewPatient() {
		patientService.viewAllPatients();
	}
	public boolean getById(int id) {
		return patientService.getById(id);
	}
	 public void delete() {
		   Scanner sc=new Scanner(System.in);
		   System.out.print("Enter Patient Id: ");
		   int id=sc.nextInt();
		   patientService.delete(id);}
	
}
