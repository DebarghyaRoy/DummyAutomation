package com.base.pageModules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.commonUtils.JSonHandler;
import com.base.webActionHelperUtils.WebActionsHelperUtils;
import com.page.locatorModules.HomePageLocators;

public class HomePage extends WebActionsHelperUtils implements HomePageLocators {

	JSonHandler jsonHandler = new JSonHandler();

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterSearchdataToSearchField(String searchData) {

		waitForElementToBeClickAble(SEARCH_BOX, 10);
		enterTextIntoElement(SEARCH_BOX, searchData);

	}

	public void navigatToUrl() {
		driver.get(url);
	}

	public void captureSearchSuggestion(String pathToJsonDataStore, String searchData) {
		List<WebElement> elements = getElements(SUGGESTION_BOX);
		jsonHandler.captureAndWriteJsonData(elements, pathToJsonDataStore, searchData);
	}

	public void genericWait(int timeOuts) {
		implicitlyWait(timeOuts);
	}

	public void clikcOnSelectedElement(String option) {
		int optionSelection = Integer.parseInt(option);
		safeClick(By.xpath("//div[@id='s-separator']/following-sibling::div[" + optionSelection + "]"));
	}

}
