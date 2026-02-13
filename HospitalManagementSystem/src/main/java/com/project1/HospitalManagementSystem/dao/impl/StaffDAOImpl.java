package com.project1.HospitalManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.StaffDAO;
import com.project1.HospitalManagementSystem.model.Staff;
import com.project1.HospitalManagementSystem.util.DBUtil;

public class StaffDAOImpl implements StaffDAO {

	@Override
	public int save(Staff staff) {
		int affectedRows=0;
		try(Connection con=DBUtil.establishConnection()){
			PreparedStatement ps=con.prepareStatement("INSERT INTO staff(name,gender,role,salary)VALUES(?,?,?,?)");
			ps.setString(1,staff.getStaffName());
			ps.setString(2,staff.getGender());
			ps.setString(3,staff.getRole());
			ps.setDouble(4,staff.getSalary());
			affectedRows=ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return affectedRows;
	}

	@Override
	public ArrayList<Staff> findAll() {
		ArrayList<Staff> staffList=new ArrayList<>();
		try(Connection con=DBUtil.establishConnection()){
		PreparedStatement ps=con.prepareStatement("SELECT * FROM staff");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Staff s=new Staff();
			s.setId(rs.getInt("id"));
			s.setStaffName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setRole(rs.getString("role"));
			s.setSalary(rs.getDouble("salary"));
			staffList.add(s);
		}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return staffList;
	}
	@Override
	   public int delete(int id) {
		   int affectedRows=0;
		   try(Connection con=DBUtil.establishConnection()){
			   PreparedStatement ps=con.prepareStatement("DELETE FROM staff WHERE id=?");
			   ps.setInt(1, id);
			    affectedRows=ps.executeUpdate();
		   }
		   catch(SQLException e) {
			   System.out.print(e);
		   }
		   return  affectedRows;
	   }
	   
     
}
