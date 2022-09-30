package com.sdet41.genericUtility;

import java.io.FileInputStream;

import java.util.Properties;

/**
 * This class will read data from property file and return the value to user
 * @author Vijayalaxmi
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This class will read data from property file for the key and return the value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pLib= new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
		
	}

}
