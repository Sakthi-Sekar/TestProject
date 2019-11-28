package com.org.test.constants;

import java.io.File;

/**
 * This class contains filepath and constants.
 * 
 * @author sakthi
 *
 */

public class ConstantPaths {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String LOCATORS_FILE = USER_HOME + "Resources" + File.separator+"locators" + File.separator + "locators.properties";

	public final static String CONFIG_FILE = USER_HOME +  File.separator +"config"+File.separator+ "config.properties";

	public final static String LOG4J_FILE = USER_HOME + "Resources" + File.separator + "log4j" + File.separator+ "log4j.properties";

	public final static String CHROME_FILE = USER_HOME + "lib" + File.separator+ "chromedriver.exe";

	public final static String FIREFOX_FILE = USER_HOME + "lib" + File.separator+ "geckodriver.exe";

	public final static String IE_FILE = USER_HOME + "lib" + File.separator+ "IEDriverServer.exe";

	public final static String DATE_FILE = USER_HOME + "Resources" + File.separator+"testdata" + File.separator + "date.xlsx";
	
	public final static String DATA_FILE = USER_HOME + "Resources" + File.separator+"testdata" + File.separator + "data.xlsx";
	
	public final static String NINJASTORE_FILE = USER_HOME + "Resources" + File.separator+"testdata" + File.separator + "ninjastore.xlsx";
	
	public final static String CREDENTIALS_FILE = USER_HOME + "Resources" + File.separator+"testdata" + File.separator + "credentials.properties";

	public static final int waitingTime = 10;

	public static final int explictWaitTime = 15;

	public static final int loadingTime = 10;

	public static final int implicitTime = 10;

	public static final long mxaximumFluentWait = 20;

	public static final long pollingWait = 3;
	
	public static final String gridNodeURL = "http://55.55.55.57:5569/wd/hub";
	
	public static String modeOfRunning="normal";

}
