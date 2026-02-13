package com.project1.HospitalManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.DoctorDAO;
import com.project1.HospitalManagementSystem.model.Doctor;
import com.project1.HospitalManagementSystem.model.Patient;
import com.project1.HospitalManagementSystem.util.DBUtil;

public class DoctorDAOImpl implements DoctorDAO {
   

   @Override
   public int save(Doctor doctorData) {
	int affectedRows=0;
	try(Connection con=DBUtil.establishConnection()){
		PreparedStatement ps=con.prepareStatement("INSERT INTO doctors(id,name,specilization,expirience) VALUES (?,?,?,?)");
		ps.setInt(1, doctorData.getDoctorId());
		ps.setString(2, doctorData.getDoctorName());
		ps.setString(3, doctorData.getSpecilization());
		ps.setFloat(4,doctorData.getExperience());
		affectedRows=ps.executeUpdate();
		}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	return affectedRows;
	
   }

   @Override
   public ArrayList<Doctor> findAll() {
	   ArrayList<Doctor> list=new ArrayList<>();
	   try(Connection con =DBUtil.establishConnection()){
			PreparedStatement ps=con.prepareStatement("SELECT* FROM doctors");
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()) {
				Doctor d=new Doctor();
				d.setDoctorId(rs.getInt("id"));
				d.setDoctorName(rs.getString("name"));
				d.setSpecilization(rs.getString("specilization"));
				d.setExperience(rs.getFloat("experience"));
		
				list.add(d);
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
		   PreparedStatement ps=con.prepareStatement("DELETE FROM doctors WHERE id=?");
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
    	PreparedStatement ps=con.prepareStatement("SELECT* FROM doctors WHERE id=?");
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
