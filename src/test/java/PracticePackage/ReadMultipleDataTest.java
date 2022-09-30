package PracticePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet41.genericUtility.ExcelFileUtility;
import com.sdet41.genericUtility.IPathConstants;

public class ReadMultipleDataTest {
	
	
	@Test(dataProvider = "getData")
	public void hotelMenu(String items, String price)
	{
		System.out.println(items+"--->"+price);
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelFileUtility eLib = new ExcelFileUtility();
		 Object[][] value = eLib.readMultipleSetOfData("readMultipleData");
		 return value;
	}

}
