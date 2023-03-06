package com.tmf.sms.batch.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
	private Connection con;
	public Connection getConnection() {
		String url = "jdbc:mysql://@127.0.0.1:3306/batchproject";
		String user = "root";
		String password = "srinu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.err.println("Database connected successfully....");
			
			String query = "create table batch("
					+ "BatchId int,CourseId int, StartDate Date,"
			+" EndDate Date, NoOfMales double, NoOfFemales double,"
			+" TotalNoOfStudents double, Status varchar(40)) ";
			
			Statement st =con.createStatement();
			st.execute(query);
			System.out.println("Table has been created successfully...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry change the jar file");
		}catch(SQLException e) {
			//System.out.println("Unable to connect with data base");
		}
		return con;
	}
}
