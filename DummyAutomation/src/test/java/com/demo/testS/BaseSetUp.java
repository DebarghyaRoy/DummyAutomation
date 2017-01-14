package com.demo.testS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.base.dataUtils.DataHelperProvider;
import com.base.dataUtils.IDataProvider;
import com.base.driverUtils.DriverProvider;

public class BaseSetUp {

	public WebDriver driver;
	DriverProvider browserProvider = new DriverProvider();
	DataHelperProvider datahelperProvider = new DataHelperProvider();
	IDataProvider dataProvider = datahelperProvider.getDataHelperProvider("properties");
	IDataProvider dataProviderExcel = datahelperProvider.getDataHelperProvider("excel");
	public final String configProperties = "..\\DummyAutomation\\TestConfigsData\\config.properties";
	public String url = dataProvider.fetchData(configProperties, "url");
	String modeOfExecution = dataProvider.fetchData(configProperties, "modeOfExecution");
	String browserName = dataProvider.fetchData(configProperties, "browser");
	String pathToJasonDataStore = "..\\DummyAutomation\\ProductJsonData\\";
	String pathToExcelData = "..\\DummyAutomation\\TestConfigsData\\TestData.xlsx";

	public WebDriver getDriver() {
		return driver;
	}

	protected void setDriver() {
		driver = browserProvider.getDriver(modeOfExecution).init(browserName);
	}

	@DataProvider(name = "SearchFunctionality")
	public Object[][] getCityDetails() {
		Object[][] arrayObject = dataProviderExcel.fetchDataSet(pathToExcelData, "DataFeed");
		return arrayObject;
	}
}
