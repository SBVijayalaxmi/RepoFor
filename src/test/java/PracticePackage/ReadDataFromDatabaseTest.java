package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con=null;
		Driver driver = new Driver();
		
		//step1:register the database
		DriverManager.registerDriver(driver);
		
		//step2: get connection for database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
		
		//step3: issue create statement
		Statement stat = con.createStatement();
		String query = "select * from sdet41";
		
		//step4: execute query
		ResultSet result = stat.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1) +" " +result.getString(2) +" " +result.getString(3));
		}
		con.close();

	}
	}

