package com.project1.HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.project1.HospitalManagementSystem.controller.DoctorController;
import com.project1.HospitalManagementSystem.controller.MedicineController;
import com.project1.HospitalManagementSystem.controller.PatientController;
import com.project1.HospitalManagementSystem.controller.StaffController;
import com.project1.HospitalManagementSystem.service.*;
import com.project1.HospitalManagementSystem.service.impl.MedicineServiceImpl;
import com.project1.HospitalManagementSystem.service.impl.PatientServiceImpl;
import com.project1.HospitalManagementSystem.util.DBUtil;

/**
 * Hello world!
 *
 */
public class App 
{     static DoctorController doctor=new DoctorController();
     static  PatientController patient=new PatientController();
      static StaffController staff=new StaffController();
       static MedicineController med=new MedicineController();
    public static void main( String[] args ) {
    
//        DoctorController doctor=new DoctorController();
//         PatientController patient=new PatientController();
//         StaffController staff=new StaffController();
//         MedicineController med=new MedicineController();
//    
         Scanner sc=new Scanner(System.in);
        System.out.println("=====HOSPITAL MANAGEMENT SYSTEM=======");
        while(true) {
        	 System.out.println("\n-----------------------------\n");
    		 System.out.println("1. Patient Management");
    		 System.out.println("2. Doctor Management");
    		 System.out.println("3. Staff Management");
    		 System.out.println("4. Medicine Management");
    		 System.out.println("5. Book Appointment"); 
    		 System.out.println("6. Exit");
    		 System.out.println("Enter Choice");
    		 int ch=sc.nextInt();
    		 switch(ch) {
    		 case 1:
    			  System.out.println("Patient Management");
    			  System.out.println("1. Add Patient");
    			  System.out.println("2. View Patient");
    			  System.out.println("3. Delete Patient");
    			  System.out.println("Enter Choice");
    			  int pch=sc.nextInt();
    			  if(pch==1) {
    				     patient.patientRegisterUI();
    			  }
    			  else if(pch==2){
    				  patient.viewPatient();
    			  }
    			  else {
    				  patient.delete();
    			  }
    			  break;
    			 
    		 case 2:
    			  System.out.println("Doctor Management");
    			  System.out.println("1. Add Doctor");
    			  System.out.println("2. View Doctor");
    			  System.out.println("3. Delete Doctor");
    			  System.out.println("Enter Choice");
    			  int dch=sc.nextInt();
    			  if(dch==1) {
 				     doctor.doctorRegisterUI();
 			  }
 			  else if(dch==2){
 				  doctor.viewDoctor();
 			  }
 			  else {
 				  doctor.delete();
 			  }
 			  break;
   			  
    		 case 3:
    			  System.out.println("Staff Management");
    			  System.out.println("1. Add Staff");
    			  System.out.println("2. View Staff");
    			  System.out.println("3. Delete Staff");
    			  System.out.println("Enter Choice");
    			  int sch=sc.nextInt();
    			  if(sch==1) {
 				     staff.staffRegisterUI();
 			  }
 			  else if(sch==2){
 				  staff.viewStaff();
 			  }
 			  else {
 				 staff.delete();
 			  }
 			  break;
    			  
    		 case 4:
    			 System.out.println("Medicine Management");
    			  System.out.println("1. Add Medicine");
    			  System.out.println("2. View Medicines");
    			  System.out.println("3. Delete Medicine");
    			  System.out.println("Enter Choice");
    			  int mch=sc.nextInt();
    			  if(mch==1) {
  				     med.MedicineRegisterUI();
  			  }
  			  else if(mch==2){
  				  med.viewMedicine();
  			  }
  			  else {
  				  med.delete();
  			  }
  			  break;
        
    		 case 5:
    			 bookAppointment();
    			 break;
    		 case 6:
    			 //exit
    			 System.out.println("THANK YOU FOR USING HOSPITAL MANAGEMENT SYSTEM !!");
    			 return;
    		 default:
    			 System.out.println("Enter Valid Choice:");
    		 }
        }}
        public static void bookAppointment() {
        	Scanner sc=new Scanner(System.in);
        	Connection con=DBUtil.establishConnection();
       	 System.out.println("Enter Patient Id:");
       	 int patientId=sc.nextInt();
       	 System.out.println("Enter Doctor Id:");
       	 int doctorId=sc.nextInt();
       	 System.out.println("Enter Apointment Date (YYYY-MM-DD):");
       	 String apointmentDate=sc.next();	
       	 if(patient.getById(patientId)&&doctor.getDoctorById(doctorId)) {
       		 if(checkDoctorAvivablity(doctorId,apointmentDate,con)) {
       			 String query="INSERT INTO appointments(patient_id,doctor_id,appointment_date) VALUES (?,?,?)";
       			  try {
       			 PreparedStatement ps=con.prepareStatement(query);
       			 ps.setInt(1, patientId);
       			 ps.setInt(2, doctorId);
       			 ps.setString(3, apointmentDate);
       			 int rows=ps.executeUpdate();
       			 if(rows>0) {
       				 System.out.println("Apppointment Booked");
       				 }
       			 else {
       				 System.out.println("Failed To Book.");
       			 }
       			 }
       			  catch(SQLException e) {
       				  System.out.println(e);
       			  }
       			 }
       		 else {
       			 System.out.println("Doctor Not Avilable!!");
       		 }
       		 }
       		 else {
       			 System.out.println("Eitehr Patient or Doctor Does'nt Exist !!");
       		 }
       	 
       	 
        

        }
        public static boolean checkDoctorAvivablity(int doctorId,String appointmentDate,Connection con) {
       	 String query="SELECT COUNT(*) FROM appointments WHERE doctor_id= ? AND appointment_date= ?";
       	 try {
       		 PreparedStatement ps=con.prepareStatement(query);
       		 ps.setInt(1, doctorId);
       		 ps.setString(2,appointmentDate);
       		 ResultSet rs=ps.executeQuery();	
       		 if(rs.next()) {
       			 int count=rs.getInt(1);
       			 if(count==0) {
       				 return true;
       			 }
       			 else {
       				 return false;
       			 }
       		 }
       	 }
       	 catch(SQLException e) {
       		 System.out.println(e);
       	 }
       	 return false;
        }
        
    
}
