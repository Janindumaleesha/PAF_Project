package org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	   	Class.forName("com.mysql.cj.jdbc.Driver");
	   	//add local user name password to connect database
	   	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid","root",""); //Enter database name
	   	 
	   	return con;
	}
	   
	public static void main(String [] args) {
		try {
			System.out.println(getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
