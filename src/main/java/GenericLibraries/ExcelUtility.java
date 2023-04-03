package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * This method is used to read data from Excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 * @author Vijayalaxmi
	 */
	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get LastRowNumber
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 * @author Vijayalaxmi
	 */
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	
	/**
	 * This method is used to write data into excel sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 * @author Vijayalaxmi
	 */
	public void writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.getRow(RowNo).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fout);
	}
	
	/**
	 * This method is used to read data in the form of key and value pair
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
	}
	
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++) 
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
