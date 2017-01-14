package com.base.dataUtils;

public class DataHelperProvider {

	public IDataProvider getDataHelperProvider(String typeOfDataHandler) {
		switch (typeOfDataHandler) {
		case "excel":
			return new ExcelDataProvider();
		case "properties":
			return new PropertiesDataProvider();
		}
		return null;

	}
}
