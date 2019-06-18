package edu.handong.csee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public ArrayList<String> getData(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		
		try (InputStream inp = is) {
		    	
		        Workbook wb = WorkbookFactory.create(inp);
		        Sheet sheet = wb.getSheetAt(0);
		        
		        for(int i = 0; i <= sheet.getLastRowNum();i++){
		        	Row row = sheet.getRow(i);
		        	for(int j = 0; j<= row.getLastCellNum(); j++) {
		        		Cell cell = row.getCell(j);
		        		if(cell == null)
		        			cell = row.createCell(3);
		        		else {
		        			values.add(cell.getStringCellValue());
		        		}
		        	}
		        }
		        
		        
		    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return values;
	}
}
