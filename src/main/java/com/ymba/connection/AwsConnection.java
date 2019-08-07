package com.ymba.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AwsConnection {
	
	private static AwsConnection aws = new AwsConnection();

	private AwsConnection() {
		super();
	}

	public static synchronized AwsConnection getInstance() {
		if(aws==null) {
			aws=new AwsConnection();
			
		}
		return aws;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try (InputStream input = AwsConnection.class.getClassLoader().getResourceAsStream("dbConn.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find dbConn.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
//            System.out.println("url: " + prop.getProperty("url"));
//            System.out.println("user: " + prop.getProperty("user"));
//            System.out.println("pass: " + prop.getProperty("password"));
            
            try {
				Class.forName(prop.getProperty("driver"));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
            try {
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return conn;
	}
	
	
}


// conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));