package com.org.test.testbase;

import java.io.IOException;

import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.org.test.constants.ConstantPaths;
import com.org.test.gridconnection.Grid;
import com.org.test.helpers.PageActions;
import com.org.test.helpers.PageManager;
import com.org.test.helpers.WaitHelperClass;
import com.org.test.reports.LogReports;

public class BaseGrid {

	public PageActions helper = new PageActions();
	public LogReports log = new LogReports();
	public PageManager pageManager = new PageManager();
	public WaitHelperClass waitHelper = new WaitHelperClass();
	public WebDriver driver;
	public Properties property;
	public String currentURL;

	/**
	 * select driver class type
	 * 
	 * @param browserType
	 * @throws IOException
	 */
	@BeforeTest
	public void openBrowser() throws IOException {
		property = pageManager.loadpropertyFile(ConstantPaths.CONFIG_FILE);
		String browserType = property.getProperty("browser");
		// if mode of running is normal
		if (ConstantPaths.modeOfRunning.equalsIgnoreCase("normal")) {

			switch (browserType) {

			case "chrome":
				ChromeOptions optionschrome = new ChromeOptions();
				optionschrome.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
				driver = new ChromeDriver(optionschrome);
				log.info("chrome browser launched");
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("firefox browser launched");
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
				driver = new InternetExplorerDriver();
				log.info("IE browser launched");
				break;

			}
		}
		// through grid mode driver will launch.

		else if (ConstantPaths.modeOfRunning.equalsIgnoreCase("grid")) {
			driver = Grid.getDriver(browserType);
			log.info("driver is opened through grid");
		}
		driver.manage().window().maximize();
		pageManager.manageTimeOuts(driver);

		log.info("URL is loading " + property.getProperty("url"));
		driver.get(property.getProperty("url"));
	}

}
