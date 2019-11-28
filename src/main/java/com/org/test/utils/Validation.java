package com.org.test.utils;

import org.testng.Assert;

/**
 * Assertion class
 * 
 * @author sakthi
 *
 */

public class Validation {
	public void validate(String actual, String expected, String errorMessage) {
		Assert.assertEquals(actual, expected, errorMessage);
	}
}
