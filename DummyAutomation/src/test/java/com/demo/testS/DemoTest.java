package com.demo.testS;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.pageModules.HomePage;
import com.base.pageModules.SearchPage;

public class DemoTest extends BaseSetUp {

	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void setUpTest() {
		setDriver();
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		homePage.navigatToUrl();
	}

	@Test(dataProvider = "SearchFunctionality")
	public void search(String searchData, String selectOption) {
		homePage.enterSearchdataToSearchField(searchData);
		homePage.genericWait(5);
		homePage.captureSearchSuggestion(pathToJasonDataStore, searchData);
		homePage.clikcOnSelectedElement(selectOption);
		searchPage.clickOnFirstProduct();
		searchPage.switchToProductSpecificPage();
		searchPage.captureProductData(pathToJasonDataStore, searchData);

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}