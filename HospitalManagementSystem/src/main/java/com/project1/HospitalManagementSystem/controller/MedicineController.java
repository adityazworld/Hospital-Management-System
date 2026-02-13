package com.project1.HospitalManagementSystem.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.project1.HospitalManagementSystem.dao.DoctorDAO;
import com.project1.HospitalManagementSystem.dao.impl.DoctorDAOImpl;
import com.project1.HospitalManagementSystem.model.Doctor;
import com.project1.HospitalManagementSystem.model.Medicine;
import com.project1.HospitalManagementSystem.service.MedicineService;
import com.project1.HospitalManagementSystem.service.impl.MedicineServiceImpl;

public class MedicineController {
   MedicineService medService;
   public MedicineController() {
	   medService=new MedicineServiceImpl();
   }
   public void MedicineRegisterUI() {
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter Medicine Name: ");
	   String medicineName=sc.nextLine();
	   System.out.print("Enter Medicine Category: ");
	   String category=sc.nextLine();
	   sc.nextLine();
	   System.out.print("Enter Quantity: ");
	   int quantity=sc.nextInt();
	   System.out.print("Enter Medicine Price: ");
	   double price=sc.nextDouble();
	   System.out.print("Enter Expiry Date(YYYY-MM-DD: ");
	   String expiry_date=sc.next();
	   medService.addMedicine(new Medicine(medicineName,category,quantity,price,expiry_date));
	   
	  
   }
   public void viewMedicine() {
	   medService.viewAllMedicine();
   }
   public void delete() {
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter Medicine Id: ");
	   int id=sc.nextInt();
	   medService.delete(id);}
}
  

