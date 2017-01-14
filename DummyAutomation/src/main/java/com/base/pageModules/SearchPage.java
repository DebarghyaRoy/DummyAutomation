package com.base.pageModules;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.base.commonUtils.JSonHandler;
import com.base.webActionHelperUtils.WebActionsHelperUtils;
import com.page.locatorModules.SearchPagesLocator;

public class SearchPage extends WebActionsHelperUtils implements SearchPagesLocator {

	JSonHandler jsonHandler = new JSonHandler();
	HashMap<String, String> productData;

	public SearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnFirstProduct() {
		boolean found = isElementPresent(FIRST_PRODUCT_NON_GRID_VIEW);
		if (found) {
			safeClick(FIRST_PRODUCT_NON_GRID_VIEW);
		} else {
			safeClick(FIRST_PRODUCT_IN_GRID_VIEW);
		}
	}

	public void switchToProductSpecificPage() {
		switchToTab(1);
		waitForElementToBeDisplayed(PRODUCT_TITLE, 10);
	}

	public void captureProductData(String pathToDataFile, String searchData) {
		productData = new HashMap<String, String>();
		String title = getText(PRODUCT_TITLE);
		productData.put("title", title);
		String reviews = getText(REVIEWS);
		productData.put("reviews", reviews);
		String priceOfProduct = getText(PRICE_OF_ITEM);
		productData.put("priceOfProduct", priceOfProduct);
		String deliveryDetails = getText(DELIVERY_DETAILS);
		productData.put("deliveryDetails", deliveryDetails);
		String merchantDetails = getText(MERCHANT_DETAILS);
		productData.put("merchantDetails", merchantDetails);
		String availability = getText(AVAILABILITY);
		productData.put("availability", availability);
		jsonHandler.captureJsonData(productData, pathToDataFile, searchData + "Product");
	}

}
