package com.myRetail.testscripts;

import static com.myRetail.setuputilities.SeleniumDriver.getDriver;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myRetail.pageobjects.HomePage;
import com.myRetail.pageobjects.LandingPage;

public class ValidateOutOfStockTab {
	private static final String Webdriver = null;
	LandingPage landingPage;
	private Object assertEquals;
	private By driver;

	@AfterClass
	public static void tearDown() {
		getDriver().close();
	}

	@BeforeClass
	public void preSetUpToOpenTheLandingPage() {
		landingPage = new HomePage().open().goToLandingPage();
	}

 @AfterMethod
  public void preSetUpToLandInAllProductTab() {
  landingPage.navigateToAllProductTab();
  }

 
 @Test(description = "Validation of Find All Product out of stock section and out of stock item")
public void verifyFindAllProductOutOfStock() {
	 
	 landingPage.navigateToOutOfProductTab();
		assertEquals(landingPage.verifyCoulmnNames(), true);
		boolean flag = landingPage.quantityCheck("0");
		assertEquals(flag, true);
			
}
}
