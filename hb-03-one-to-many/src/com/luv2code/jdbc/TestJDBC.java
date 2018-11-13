package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String usr="hbstudent";
		String pass="hbstudent";		 
		
		try {
			System.out.println("Connecting to Database "+jdbcURL);
			Connection connection= DriverManager.getConnection(jdbcURL, usr, pass);
			System.out.println("Connection successful!!!");
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
