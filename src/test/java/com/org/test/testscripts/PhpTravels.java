package com.org.test.testscripts;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.test.constants.ConstantPaths;
import com.org.test.testbase.BaseClass;
import com.org.test.testbase.BaseGrid;
import com.org.test.testbase.BaseParallel;
import com.org.test.utils.ExcelLoadData;




public class PhpTravels extends BaseClass {
	String actualURL, expectedURL, actualText, expectedText, loadText, testValue, qtyvalue, actualAvailabilty,
			actualPrice, expectedPrice, actualTax, expectedTax, expectedAvailability;
	Properties userProperty;

	@Test
	public void homePage() throws Exception {
		property = pageManager.loadpropertyFile(ConstantPaths.LOCATORS_FILE);
		userProperty = pageManager.loadpropertyFile(ConstantPaths.CONFIG_FILE);
		ExcelLoadData load = new ExcelLoadData(ConstantPaths.NINJASTORE_FILE);

		// URL validation
		actualURL = driver.getCurrentUrl();
		expectedURL = userProperty.getProperty("url");
		Assert.assertEquals(actualURL, expectedURL, "URL doesn't match");
		log.info("Url is matched :" + actualURL);

		// Homepage text validation
        //Javascript
//		property = pageManager.loadpropertyFile(ConstantPaths.LOCATORS_FILE);
//		actualText=helper.getTextValue(driver, property.getProperty("homepagetext"));
//		return actualText;
		// return actualText;

		actualText = helper.getElement(driver, property, "homepagetextvalidate").getText();
		expectedText = load.getCellData("ninja", "Validation", 2);
		Assert.assertEquals(actualText, expectedText, "Value has no match");
		log.info("Assert passed and the text is :" + expectedText);
//Passing test value as iPhone 
		testValue = load.getCellData("ninja", "Validation", 3);
		helper.getElement(driver, property, "search").sendKeys(testValue);
		log.info("The test value is :" + testValue);
//click on search button
		helper.getElement(driver, property, "searchbutton").click();
		log.info("Searching...iPhone");
		// click on iphone link
		helper.getElement(driver, property, "clicklink").click();
		log.info("clicked on iPhone link");
		// click on and clear the existing number of quantity
		helper.getElement(driver, property, "iphoneqty").clear();
		// passing the qty value as 2
		qtyvalue = load.getCellData("ninja", "Qty", 3);
		helper.getElement(driver, property, "iphoneqty").sendKeys(qtyvalue);
		log.info("iphone qty is now 2");
		// iphone of qty 2 is now added to cart
		helper.getElement(driver, property, "iphoneaddcart").click();
		log.info("iphone of qty 2 is now added to the cart");
		// clear search
		helper.getElement(driver, property, "search").clear();
		// seaarch macbook
		testValue = load.getCellData("ninja", "Validation", 4);
		helper.getElement(driver, property, "search").sendKeys(testValue);
		log.info("The test value is :" + testValue);
		// click on search button
		helper.getElement(driver, property, "searchbutton").click();
		log.info("Searching...MacBook Air");
		// click on link
		helper.getElement(driver, property, "clicklink").click();
		log.info("clicked on MacBook Air link");
		// click on and clear the existing number of quantity
		helper.getElement(driver, property, "iphoneqty").clear();
		// passing the qty value as 3
		qtyvalue = load.getCellData("ninja", "Qty", 4);
		helper.getElement(driver, property, "iphoneqty").sendKeys(qtyvalue);
		log.info("MacBook Qty qty is now 3");
		// validate availability
		actualAvailabilty = helper.getElement(driver, property, "availability").getText();
		expectedAvailability = load.getCellData("ninja", "VerifyIPHONE", 2);
		Assert.assertEquals(actualAvailabilty, expectedAvailability, "No availability matches");
		log.info("Availability is in stock");
//product price
		actualPrice = helper.getElement(driver, property, "productprice").getText();
		expectedPrice = load.getCellData("ninja", "VerifyIPHONE", 3);
		Assert.assertEquals(actualPrice, expectedPrice, "Price doesn't match");
		log.info("Product price is :" + actualPrice);
//EX-Tax
		actualTax = helper.getElement(driver, property, "extax").getText();
		expectedTax = load.getCellData("ninja", "VerifyIPHONE", 4);
		Assert.assertEquals(actualTax, expectedTax, "Tax has no match");
		log.info("Ex-Tax:" + actualTax);
//add to cart
		helper.getElement(driver, property, "iphoneaddcart").click();
		log.info("iphone of qty 3 is now added to the cart");
		// click on added items on cart
		helper.getElement(driver, property, "cartsymbol").click();
		log.info("click on cart symbol");
		// clicked on view cart
		helper.getElement(driver, property, "viewcart").click();
		log.info("clicked on view cart");
		// remove item
		helper.getElement(driver, property, "remove").click();
		log.info("removing...iPhone");
	}

}
