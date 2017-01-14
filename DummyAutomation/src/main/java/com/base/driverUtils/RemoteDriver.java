package com.base.driverUtils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriver implements IDriver {

	DesiredCapabilities caps;
	String remoteHuburl;

	@Override
	public WebDriver init(String browserName) {
		switch (browserName) {
		case "firefox":
			try {
				return new RemoteWebDriver(new URL(remoteHuburl), caps.firefox());
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		case "chrome":
			try {
				return new RemoteWebDriver(new URL(remoteHuburl), caps.chrome());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		case "ie":
			try {
				return new RemoteWebDriver(new URL(remoteHuburl), caps.internetExplorer());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			try {
				return new RemoteWebDriver(new URL(remoteHuburl), caps.firefox());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
