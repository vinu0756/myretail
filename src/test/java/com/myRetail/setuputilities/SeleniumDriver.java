package com.myRetail.setuputilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Selenium driver wrapper
 *
 * @author mlipski
 */
public class SeleniumDriver {

	static WebDriver driver;

	public static WebDriver getDriver() {
		
		
		if (driver == null) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			//File geckoExecutable = new File("GeckoDriver\\geckodriver.exe");
			
			File geckoExecutable = new File("C:\\Users\\hegvi001\\Documents\\GitHub\\myretail\\GeckoDriver\\chromedriver.exe"); // GeckoDriver for windows
			
			//GeckoDriver for mac
			
			//File geckoExecutable = new File("/Users/vinvij/Desktop/MyRetailAutomationSuite_latest/GeckoDriver/geckodriver");
			
			
			System.out.println(geckoExecutable.getAbsolutePath());
			//System.setProperty("webdriver.gecko.driver", geckoExecutable.getAbsolutePath());
			System.setProperty("webdriver.chrome.driver", geckoExecutable.getAbsolutePath());
			//driver = new FirefoxDriver(); // can be replaced with HtmlUnitDriver
											// for better performance
			
			driver = new ChromeDriver();
		}
		return driver;

	}
}
