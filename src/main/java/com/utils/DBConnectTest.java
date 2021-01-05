
package com.utils;

import java.sql.*;
import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.common.FormElementObject;

public class DBConnectTest {
	static String url = "jdbc:mysql://localhost:3306/data";
	static String user = "root";
	static String password = "root";
	static Connection con = null;
	static Statement st = null;
	static ResultSet res = null;

	//@Test(priority = 1)
	static public void database_connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(url, user, password);

		System.out.println("Connection successfull");

	}
    
//	@Test(priority = 2,dependsOnMethods = { "database_connect" })
	static public void insertToDB(FormElementObject form) throws SQLException, ClassNotFoundException, ParseException {
		database_connect();
		String d=ConfigVar.dateFormatter(form.getDob().replace('/','-'));
	
	
		String query = "insert into formdata values('"+ form.getFirstname()+"','" + form.getLastname()+"','"
				+ form.getEmail()+"','"+" ','"+ form.getCurrCompany()+"','"+ form.getMobile()+"','"+ d+"','"+ form.getPosition()+"','"
						+ form.getPortfollio()+"','"+ form.getSalary()+"','"+ form.getFile()+"','"+ form.getRelocate()+"','"+"yes'"
				
				+")";

		st = con.createStatement();
		st.executeUpdate(query);
		
	}

//	@Test(priority = 3,dependsOnMethods = { "database_connect" })
	static public void getFromDB() throws SQLException, ClassNotFoundException {
		database_connect();
		String query = "select * from formdata";

		st = con.createStatement();
		res = st.executeQuery(query);
		String rowData="";
		
		while(res.next()) {
			rowData=res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)
			+" "+res.getString(5)+" "+res.getString(6)+" "+res.getDate(7)+" "+res.getString(8)+" "+res.getString(9)
			+" "+res.getString(10)+" "+res.getString(11)+" "+res.getString(12)+" "+res.getString(13);
			
		}

		System.out.println("the rowData:  " + rowData);
	}

	public static String getEmailStatusfromDB(FormElementObject form) throws ClassNotFoundException, SQLException {
		database_connect();
		String query = "select * from formdata where email="+form.getEmail();

		st = con.createStatement();
		res = st.executeQuery(query);
		
		String emailStatus=null;;
	
		while(res.next()) {
			 emailStatus=res.getString(13);
			
		}
		return emailStatus;

		
		
	}
	
	
}
