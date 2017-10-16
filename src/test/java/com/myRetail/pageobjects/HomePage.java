package com.myRetail.pageobjects;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object representing github home page.
 *
 * @author mlipski
 */
public class HomePage extends BasePage<HomePage> {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.titleContains("myRetail");
	}

	@Override
	public String getPageUrl() {
		return "";
	}

	public LandingPage goToLandingPage() {
		return new LandingPage().openPage(LandingPage.class);
	}

	public HomePage open() {
		return new HomePage().openPage(HomePage.class);
	}

}
