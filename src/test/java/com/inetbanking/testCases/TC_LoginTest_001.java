package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		logger.info("URL is Open");
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered User name");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Click on Login button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Pass");
		} else {
			caprureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test Fail");
		}
	}

}
