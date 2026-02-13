package com.project1.HospitalManagementSystem.service.impl;

import java.util.ArrayList;

import com.project1.HospitalManagementSystem.dao.StaffDAO;
import com.project1.HospitalManagementSystem.dao.impl.StaffDAOImpl;
import com.project1.HospitalManagementSystem.model.Staff;
import com.project1.HospitalManagementSystem.service.StaffService;

public class StaffServiceImpl implements StaffService {
	StaffDAO staffDao;
	public StaffServiceImpl(){
		staffDao=new StaffDAOImpl();
	}

	@Override
	public void registerStaff(Staff staff) {
		int rows=staffDao.save(staff);
		if(rows>0) {
			System.out.println("Data Inserted Successfully");
		}
		else {
			System.out.println("Failed To Insert");
		}
		
		
	}

	@Override
	public void findAllStaff() {
		ArrayList<Staff> staffList=staffDao.findAll();
		if(staffList.size()>0) {
			System.out.println("Staff");
			System.out.println("+-----------+------------------+---------+--------------+-----------+");
			System.out.println("| Staff Id  | Staff Name       | Gender  | Role         | Salary    |");
			System.out.println("+-----------+------------------+---------+--------------+-----------+");
			for(Staff s:staffList) {
				int id=s.getId();
				String name=s.getStaffName();
				String gender=s.getGender();
				String role=s.getRole();
				double salary=s.getSalary();
				System.out.printf("|%-11s|%-18s|%-9s|%-14s|%-11s|\n",id,name,gender,role,salary);
				System.out.println("+-----------+------------------+---------+--------------+-----------+");
			}
		}
		else {
			System.out.println("No Data found");
		}
		
	}

	@Override
	public void delete(int id) {
		int rows=staffDao.delete( id);
		if(rows>0) {
			System.out.println("Deletion Successfull");
		}
		else {
			System.out.println("Failed ");
		}
		
	}
	

	
	
	

}
