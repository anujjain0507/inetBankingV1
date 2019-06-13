package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomeTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered User Name");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Click add new Customer link");
		addcust.clickAddNewCustomer();
		logger.info("Enter the User Details");
		addcust.custName("anuj");
		addcust.custgendedr("male");
		addcust.custdob("05", "07", "1984");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Mumbai");
		addcust.custstate("Maharashtra");
		addcust.custpinno("400096");
		addcust.custtelephoneno("1234567890");
		String email = randomstring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("hdgs343");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("Validation Start....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("Test Case passed....");
		} else {
			logger.info("Test Case failed....");
			caprureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
