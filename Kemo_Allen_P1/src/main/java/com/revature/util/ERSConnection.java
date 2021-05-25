package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ERSConnection {
	//Run -> Run Configurations -> Java Application -> <The Application> -> Environment 
		private static final String URL = System.getenv("aws_url"); 
		private static final String USERNAME = System.getenv("aws_username");
		private static final String PASSWORD = System.getenv("aws_password");
		
		private final static Logger LOG = Logger.getLogger(ERSConnection.class);

		private static Connection conn;
		
		public static Connection getConnection()  {
			try { 
				
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				LOG.error("There was an issue connecting to the data base.");
			}
			
			return conn;
		}

}
