package com.osa.JDBC_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBC_Selenium {
	//1. Create connection with database
	//2. create statement
	//3. execute the statement
	//4. store data into ResultSet
	//5. close the connection


	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\windows\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://osaconsultingtech.com/");

		// 1. Create connection with database

		String jdbcUrl = "jdbc:mysql://localhost:3306/osa_students";
		String username = "root";
		String password = "";

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			// 2. create statement
			Statement stmt = con.createStatement();

			// 3. execute the statement
			// 4. store data into ResultSet

			String FetchData = "SELECT * FROM Student_Info";
			ResultSet rs = stmt.executeQuery(FetchData);

			// System.out.println("Student_OSA table has been created.....");
			while (rs.next()) {
//						String sID = rs.getString("SID");
//						String name = rs.getString("Name");
//						String email = rs.getString("Email");
//						String phone = rs.getString("P_Number");
				String user1 = rs.getString("username");
				String pass1 = rs.getString("password");
				
				driver.findElement(By.xpath("//*[@id=\"ftco-nav\"]/ul/li[7]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(user1);
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass1);
				driver.findElement(By.xpath("//*[@id=\"login_button\"]")).click();

				// System.out.println("Student ID: "+sID+" Student Name: "+name+" Student Email:
				// "+email+" Student Phone: "+phone );
			}
			// 4. close the connection

			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
