package com.project1.HospitalManagementSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.project1.HospitalManagementSystem.model.Patient;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/hospital";
	//to store username of the database
	private static final String username ="root";
	//to store password of the database
	private static final String password ="Kaif@123";
	
	//to store Connection data
	private static Connection con=null;
	
	//method to establish connection
	public static Connection establishConnection()
	{
		try
		{
			con = DriverManager.getConnection(url,username,password);
			
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
		return con;
	}
	
	//method to close the connection
	public static void closeConnection()
	{
		try {
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException sqe)
		{
			System.out.println(sqe);
		}
	}

	
	
	
	//method to create tables if not exists
	
		
	}

