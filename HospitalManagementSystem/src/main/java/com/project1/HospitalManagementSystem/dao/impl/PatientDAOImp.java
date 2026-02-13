package com.project1.HospitalManagementSystem.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.PatientDAO;
import com.project1.HospitalManagementSystem.model.Patient;
import com.project1.HospitalManagementSystem.util.DBUtil;

public class PatientDAOImp implements PatientDAO{
	@Override
     public int save(Patient patientData) {
    	 int insertedrows=0;
    	 try(Connection con=DBUtil.establishConnection()){
    		 PreparedStatement ps=con.prepareStatement("INSERT INTO patients(name,age,gender,disease)VALUES(?,?,?,?)");
    		 ps.setString(1,patientData.getName());
    		 ps.setInt(2,patientData.getAge());
    		 ps.setString(3,patientData.getGender());
    		 ps.setString(4,patientData.getDisease());
    		 insertedrows=ps.executeUpdate();
    	 }
    	 catch(SQLException e) {
    		 
    	 }
    	 return insertedrows;
     }
     public ArrayList<Patient> findAll() {
    	 ArrayList<Patient> list=new ArrayList<>();
			
 		try(Connection con =DBUtil.establishConnection()){
 			PreparedStatement ps=con.prepareStatement("SELECT* FROM patients");
 			ResultSet rs=ps.executeQuery();
 			
 			while(rs.next()) {
 				Patient p=new Patient();
 				p.setPatientId(rs.getInt("id"));
 				p.setName(rs.getString("name"));
 				p.setAge(rs.getInt("age"));
 				p.setGender(rs.getString("gender"));
 				p.setDisease(rs.getString("disease"));
 				list.add(p);
 			}
 			
 		}
 		catch(SQLException e) {
 			System.out.println(e);
 		}
 		return list;
 	}
  @Override
     public int delete(int id) {
  	   int affectedRows=0;
  	   try(Connection con=DBUtil.establishConnection()){
  		   PreparedStatement ps=con.prepareStatement("DELETE FROM patients WHERE id=?");
  		   ps.setInt(1, id);
  		    affectedRows=ps.executeUpdate();
  	   }
  	   catch(SQLException e) {
  		   System.out.print(e);
  	   }
  	   return  affectedRows;
     }
 	@Override
     public boolean findById(int id) {
    	    try(Connection con=DBUtil.establishConnection()){
    	    	PreparedStatement ps=con.prepareStatement("SELECT* FROM patients WHERE id=?");
    	    	ps.setInt(1, id);
    			ResultSet rs=ps.executeQuery();
    			if(rs.next()) {
    				return true;
    			}
    			else {
    				return false;
    			}
    	    }
    	    catch(SQLException e) {
    	    	System.out.print(e);
    	    }
    	    return false;

    	   }
}
