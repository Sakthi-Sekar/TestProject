package com.org.test.utils;



import java.io.IOException;


import org.testng.annotations.DataProvider;

import com.org.test.constants.ConstantPaths;




/**Data provider class
 * 
 * @author sakthi
 *
 */

public class DataProviderClass {
	
	@DataProvider(name="userData")
	public  String[][] getdata() throws IOException {

	   return ExcelReader.getUserData(ConstantPaths.DATE_FILE);
	}
	
	
	
}
