package com.base.dataUtils;

public interface IDataProvider {

	public Object[][] fetchDataSet(String... dataFileInfo);
	public String fetchData(String... dataFileInfo);
}
