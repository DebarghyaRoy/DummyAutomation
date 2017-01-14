package com.base.commonUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;

public class JSonHandler {

	public void captureAndWriteJsonData(List<WebElement> elements, String pathToDataFile, String searchData) {

		JSONObject[] elementsAttribute = new JSONObject[elements.size()];
		JSONObject productType = new JSONObject();
		JSONObject element = new JSONObject();
		for (int i = 0; i <= elements.size() - 1; i++) {
			String elementText = elements.get(i).getText();
			String dataAlis = elements.get(i).getAttribute("data-alias");
			elementsAttribute[i] = new JSONObject();
			{
				elementsAttribute[i].put("ElementName", elementText);
				elementsAttribute[i].put("type", dataAlis);
				element.put("Elemenet: " + i, elementsAttribute[i]);

			}
			productType.put(searchData, element);
			writeToJsonFile(pathToDataFile, searchData, productType);

		}
	}

	public void writeToJsonFile(String pathToDataFile, String searchData, JSONObject jSon) {
		try {
			FileWriter file = new FileWriter(pathToDataFile + searchData + ".json");
			file.write(jSon.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void captureJsonData(HashMap<String, String> data, String pathToDataFile, String searchData) {
		JSONObject productD = new JSONObject();
		JSONObject entityDetails = new JSONObject();
		JSONObject productDatas = new JSONObject();

		for (Map.Entry<String, String> productDataLoader : data.entrySet()) {
			productDatas.put(productDataLoader.getKey(), productDataLoader.getValue());
		}
		entityDetails.put("Product Data", productDatas);
		writeToJsonFile(pathToDataFile, searchData, entityDetails);

	}
}