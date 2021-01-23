package com.osa.JDBC_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//1. Create connection with database
//2. create statement
//3. execute the statement
//4. store data into ResultSet
//5. close the connection

public class RetrieveData {
	
	public static void main(String[] args) {
		ExecuteData("jdbc:mysql://localhost:3306/osa_students","root","");
	}
	
	public static void ExecuteData(String jdbcUrl,String username,String password) {
		Connection con=null;
		Statement stmt=null;

		try {
			//1. Create connection with database
			
			con = DriverManager.getConnection(jdbcUrl, username, password);
			
			// 2. create statement
			stmt = con.createStatement();
				//Select command
			//3. execute the statement 
			//4. store data into ResultSet
			String FetchData = "SELECT * FROM Student_OSA";
			//4. store data into ResultSet
			ResultSet rs =stmt.executeQuery(FetchData);
			
			while(rs.next()) {
				String sID = rs.getString("SID");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String phone = rs.getString("P_Number");
				
				System.out.println("Student ID: "+sID+" Student Name: "+name+" Student Email: "+email+" Student Phone: "+phone );
			}
			
			//System.out.println("new student info has been entered");

			// 4. close the connection

			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * Connection con = DriverManager.getConnection(jdbcUrl, username, password);
	 * Statement stmt = con.createStatement();
	 * ResultSet rs =stmt.executeQuery(FetchData);//execute and store data into result set
	 * stmt.executeUpdate(CREATE_TABLE);// execute data to create a new table
	 * stmt.execute(input);//execute to input/update data
	 */


}
