package com.project1.HospitalManagementSystem.controller;

import java.util.Scanner;

import com.project1.HospitalManagementSystem.model.Staff;
import com.project1.HospitalManagementSystem.service.StaffService;
import com.project1.HospitalManagementSystem.service.impl.StaffServiceImpl;

public class StaffController {
	StaffService staffService;
   public StaffController() {
	 staffService=new StaffServiceImpl();
 }
   public void staffRegisterUI() {
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter Staff name: ");
	   String name=sc.nextLine();
	   System.out.print("Enter Staff gender(M/F): ");
	   String gender=sc.nextLine();
	   System.out.print("Enter Staff role: ");
	   String role=sc.nextLine();
	   System.out.print("Enter Staff Salary: ");
	   double salary=sc.nextDouble();
	   staffService.registerStaff(new Staff(name,gender,role,salary));
	   
   }
   public void viewStaff() {
	   staffService.findAllStaff();
   }
   public void delete() {
	   Scanner sc=new Scanner(System.in);
	   System.out.print("Enter Staff Id: ");
	   int id=sc.nextInt();
	   staffService.delete(id);}
}
