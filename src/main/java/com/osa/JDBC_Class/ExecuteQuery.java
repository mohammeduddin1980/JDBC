package com.osa.JDBC_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//1. Create connection with database
//2. create statement
//3. execute the statement
//4. close the connection

public class ExecuteQuery {

	public static void main(String[] args) {
		
		ExecuteData("jdbc:mysql://localhost:3306/osa_students","root","");

//		// 1. Create connection with database
//
//		String jdbcUrl = "jdbc:mysql://localhost:3306/osa_students";
//		String username = "root";
//		String password = "";
//
//		try {
//			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
//			// 2. create statement
//			Statement stmt = con.createStatement();
//
//			// creating a new table
//
//			System.out.println("");
//
//			// 4. close the connection
//
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

	}
	public static void ExecuteData(String jdbcUrl,String username,String password) {
		Connection con=null;
		Statement stmt=null;

		try {
			//1. Create connection with database
			
			con = DriverManager.getConnection(jdbcUrl, username, password);
			
			// 2. create statement
			stmt = con.createStatement();
				//insert, delete, update etc.
			//3. execute the statement
			String input = "INSERT INTO Student_Info VALUES(101,'masum','masum.nj@gmail.com','9292225368','masum1','masum1')";
			stmt.execute(input);
			
			
			System.out.println("new student info has been entered");

			// 4. close the connection

			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
