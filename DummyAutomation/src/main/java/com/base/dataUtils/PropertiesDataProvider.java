package com.base.dataUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDataProvider implements IDataProvider {

	FileInputStream fis=null;

	@Override
	public Object[][] fetchDataSet(String... dataFileInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fetchData(String... dataFileInfo) {

		String dataValue;
		String pathToFile = dataFileInfo[0];
		String key = dataFileInfo[1];
		Properties properties = new Properties();
		try {
			fis=new FileInputStream(pathToFile);
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataValue = properties.getProperty(key);
		return dataValue;
	}

}
