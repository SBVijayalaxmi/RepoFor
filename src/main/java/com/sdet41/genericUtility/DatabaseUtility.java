package com.sdet41.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to read data from database
 * @author Vijayalaxmi
 *
 */
public class DatabaseUtility {
	/**
	 * This method is used to get database connection
	 * 
	 */
	
	Connection con= null;
	
	public void connectToDB() throws Throwable
	{
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
}
	
	/**
	 * This method  will execute the query and return the matching data to the user
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executequeryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
		 data = result.getString(columnIndex);
		 if(data.equalsIgnoreCase(expData))
		 {
			 flag=true;  //flag rising
			 break;
		 }
		}
		if(flag)
		{
			System.out.println(data+"------>data verified");
			return expData;
		}
		else
		{
			System.out.println(data+"---> data not verified");
			return "";
		}
	}
	
	/**
	 * THis method is used to close the database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
		
	}
}
