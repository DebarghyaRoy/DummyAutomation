package com.base.driverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LocalDriver implements IDriver {

	public WebDriver init(String browserName) {
		switch (browserName) {
		case "firefox":
			return new FirefoxDriver();

		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"..\\DummyAutomation\\DriversExe\\chromedriver.exe");
			return new ChromeDriver();

		case "ie":
			System.setProperty("webdriver.ie.driver",
					"..\\DummyAutomation\\DriversExe\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		default:
			return new FirefoxDriver();
		}
	}

}
