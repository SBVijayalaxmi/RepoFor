package com.sdet41.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains Java specific generic methods
 * @author Vijayalaxmi
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to get random number within the boundry from 0 to 10000
	 * @return random
	 */
	
	public int randomNumber()
	{
		Random ran= new Random();
		int random= ran.nextInt(10000);
		return random;
	}

	/**
	 * This method is used get SystemDate and Time
	 * @return
	 */
	public String systemDate()
	{
		Date date= new Date();
		String systemDate = date.toString();
		return systemDate;
	}
}
