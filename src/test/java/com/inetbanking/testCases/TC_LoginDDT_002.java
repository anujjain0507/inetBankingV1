package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtills;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user Name provided");
		lp.setPassword(pwd);
		logger.info("User password Provided");
		lp.clickSubmit();
		logger.info("Click the Login Button");
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			caprureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
			logger.warn("Login failure");
			
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			Thread.sleep(3000);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rownum = XLUtills.getRowCount(path, "Sheet1");
		int colcount = XLUtills.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtills.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
