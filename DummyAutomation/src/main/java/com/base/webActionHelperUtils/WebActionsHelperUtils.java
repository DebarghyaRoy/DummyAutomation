package com.base.webActionHelperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.testS.BaseSetUp;

public class WebActionsHelperUtils extends BaseSetUp {

	protected WebDriver driver;

	public WebActionsHelperUtils(WebDriver driver) {

		this.driver = driver;
	}

	public void safeClick(By element) {

		waitForElementToBeClickAble(element, 30);
		driver.findElement(element).click();
	}

	public List<WebElement> getElements(By elements) {
		return driver.findElements(elements);
	}

	public void waitForWebElementsToBeDisplayed(By elements, int timeOuts) {
		WebDriverWait wait = new WebDriverWait(driver, timeOuts);
		wait.until(ExpectedConditions.visibilityOfAllElements(getElements(elements)));
	}

	public void waitForElementToBeClickAble(By element, int timeOutSeconds) {
		WebDriverWait waitForElement = new WebDriverWait(driver, timeOutSeconds);
		waitForElement.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeDisplayed(By element, int timeOuts) {
		WebDriverWait wait = new WebDriverWait(driver, timeOuts);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void enterTextIntoElement(By element, String textToBeEntered) {
		driver.findElement(element).sendKeys(textToBeEntered);
	}

	public String getText(By element) {
		return driver.findElement(element).getText();

	}

	public String getAttribute(By element, String attribute) {
		return driver.findElement(element).getAttribute(attribute);
	}

	public boolean isSelected(By element) {
		boolean isElementSelected = false;
		if (driver.findElement(element).isSelected() == true) {
			isElementSelected = true;
		}
		return isElementSelected;
	}

	public void clearField(By element) {
		driver.findElement(element).clear();
	}

	public void implicitlyWait(int timeOuts) {
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
	}

	public boolean isElementPresent(By element) {
		try {
			driver.findElement(element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void switchToTab(int indexOfTab) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(indexOfTab));

	}
}
