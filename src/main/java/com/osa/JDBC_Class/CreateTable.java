package com.osa.JDBC_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//1. Create connection with database
//2. create statement
//3. execute the statement
//4. close the connection

public class CreateTable {
	
	private static final String CREATE_TABLE="CREATE TABLE Student_Info("
			+ "SID INT NOT NULL,"
			+ "Name VARCHAR(50) NOT NULL,"
			+ "Email VARCHAR(50),"
			+ "P_Number VARCHAR(50) NOT NULL,"
			+ "username VARCHAR(50) NOT NULL,"
			+ "password VARCHAR(50) NOT NULL,"
			+ "PRIMARY KEY (SID))";
	
	public static void main(String[] args) {
		
		//1. Create connection with database
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/osa_students";
		String username = "root";
		String password = "";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			//2. create statement
			Statement stmt = con.createStatement();
			
			//creating a new table
			stmt.executeUpdate(CREATE_TABLE);
			
			System.out.println("Student_OSA table has been created.....");
			
			//4. close the connection
			
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
