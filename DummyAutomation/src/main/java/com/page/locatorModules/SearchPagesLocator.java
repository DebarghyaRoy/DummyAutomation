package com.page.locatorModules;

import org.openqa.selenium.By;

public interface SearchPagesLocator {

	By FIRST_PRODUCT_NON_GRID_VIEW = By
			.xpath("//li[@id='result_0']/div/div/div/div[2]/div[@class='a-row a-spacing-small']");
	By FIRST_PRODUCT_IN_GRID_VIEW = By.xpath("//li[@id='result_0']");
	By PRODUCT_TITLE = By.xpath("//div[@id='titleSection']");
	By REVIEWS = By.xpath("//span[@id='acrCustomerReviewText']");
	By PRICE_OF_ITEM = By.xpath("//span[contains(@id,'priceblock')]");
	By DELIVERY_DETAILS = By.xpath("//div[@id='ddmDeliveryMessage']");
	By MERCHANT_DETAILS = By.xpath("//div[@id='merchant-info']");
	By AVAILABILITY = By.xpath("//div[@id='availability']");
}
