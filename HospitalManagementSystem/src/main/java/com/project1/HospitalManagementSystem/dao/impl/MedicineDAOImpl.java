package com.project1.HospitalManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.MedicineDAO;
import com.project1.HospitalManagementSystem.model.Medicine;
import com.project1.HospitalManagementSystem.util.DBUtil;

public class MedicineDAOImpl implements MedicineDAO {

	@Override
	public int save(Medicine medicine) {
		int affectedRows=0;
		try(Connection con=DBUtil.establishConnection()){
			PreparedStatement ps=con.prepareStatement("INSERT INTO medicine (name,category,quantity,price,expiry_date)VALUES(?,?,?,?,?)");
			ps.setString(1,medicine.getMedicineName());
			ps.setString(2,medicine.getCategory());
			ps.setInt(3,medicine.getQuantity());
			ps.setDouble(4,medicine.getPrice());
			ps.setString(5,medicine.getExpiryDate());
			affectedRows=ps.executeUpdate();
			}
		catch(SQLException e) {
			System.out.println(e);
		}
		return affectedRows;
	}

	@Override
	public ArrayList<Medicine> findAll() {
		ArrayList<Medicine> medList=new ArrayList<>();
		try(Connection con=DBUtil.establishConnection() ) {
			 PreparedStatement ps=con.prepareStatement("SELECT*FROM medicine");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 Medicine m=new Medicine();
				 m.setId(rs.getInt("id"));
				 m.setMedicineName(rs.getString("name"));
				 m.setCategory(rs.getString("category"));
				 m.setQuantity(rs.getInt("quantity"));
				 m.setPrice(rs.getDouble("price"));
				 m.setExpiryDate(rs.getString("expiry_date"));
				 m.setDateAddedOn(rs.getString("added_on"));
				 medList.add(m);
				 
			 }
		}
		catch(SQLException e) {
			System.out.print(e);
		}
		return medList;
	}
	@Override
	   public int del(int id) {
		   int affectedRows=0;
		   try(Connection con=DBUtil.establishConnection()){
			   PreparedStatement ps=con.prepareStatement("DELETE FROM medicine WHERE id=?");
			   ps.setInt(1, id);
			    affectedRows=ps.executeUpdate();
		   }
		   catch(SQLException e) {
			   System.out.print(e);
		   }
		   return  affectedRows;
	   }
	 

}
