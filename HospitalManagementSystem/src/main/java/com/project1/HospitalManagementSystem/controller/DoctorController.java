package com.project1.HospitalManagementSystem.controller;

import java.util.Scanner;

import com.project1.HospitalManagementSystem.model.Doctor;
import com.project1.HospitalManagementSystem.service.DoctorService;
import com.project1.HospitalManagementSystem.service.impl.DoctorServiceImpl;

public class DoctorController {
         DoctorServiceImpl doctorService;
         public DoctorController() {
        	 doctorService=new DoctorServiceImpl();
         }
         public void doctorRegisterUI() {
        	 Scanner sc=new Scanner(System.in);
        	 sc.nextLine();
        	 System.out.print("Enter Doctor Id:");
        	 int doctorId=sc.nextInt();
        	 sc.nextLine();
        	 System.out.print("Enter Doctor Name: ");
        	 String doctorName=sc.nextLine();
        	 System.out.print("Enter Doctor Specilization: ");
        	 String specilization=sc.nextLine();
        	 System.out.print("Enter Years Of Experience: ");
        	 float experience=sc.nextFloat();
        	 doctorService.registerDocotor(new Doctor(doctorId,doctorName,specilization,experience));
        	 
         }
         public void viewDoctor() {
        	 doctorService.viewAllDoctor();
         }
         public boolean getDoctorById(int id) {
        	 return doctorService.getById(id);
         }
         public void delete() {
      	   Scanner sc=new Scanner(System.in);
      	   System.out.print("Enter Doctor Id: ");
      	   int id=sc.nextInt();
      	   doctorService.delete(id);}
}
