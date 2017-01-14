package com.base.dataUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider implements IDataProvider {

	FileInputStream fis = null;
	private static XSSFWorkbook workBook = null;
	private static XSSFCell Cell;
	private static XSSFSheet sheet;

	public static String[][] excelDataSet = null;

	@Override
	public Object[][] fetchDataSet(String... dataFileInfo) {
		String excelFilePath = dataFileInfo[0];
		String excelSheetName = dataFileInfo[1];
		File file = new File(excelFilePath);

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workBook.getSheet(excelSheetName);
		int ci, cj;
		int rowCount = sheet.getLastRowNum();
		int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
		excelDataSet = new String[rowCount][totalCols - 1];
		ci = 0;
		for (int i = 1; i <= rowCount; i++, ci++) {
			cj = 0;
			for (int j = 1; j <= totalCols - 1; j++, cj++) {

				try {
					excelDataSet[ci][cj] = getCellData(i, j);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return excelDataSet;

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = sheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			}

			else if (dataType == XSSFCell.CELL_TYPE_NUMERIC) {
				int i = (int) Cell.getNumericCellValue();
				return Integer.toString(i);
			}

			else {

				String CellData = Cell.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {

			throw (e);

		}

	}

	@Override
	public String fetchData(String... dataFileInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
