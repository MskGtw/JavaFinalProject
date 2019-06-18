package edu.handong.csee;

import java.io.*;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZipReader {

	public static void main(String[] args) {
		ZipReader zipReader = new ZipReader();
		zipReader.run(args);
	}

	private void run(String[] args) {
		//String path = args[0];
		
		readFileInZip("0001.zip");
		
	}

	public void readFileInZip(String path) {
		ZipFile zipFile;
		try {
			Workbook xlsxWb = new XSSFWorkbook();
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			//create excel sheet
			Sheet sheet1 = xlsxWb.createSheet("result");
			
			//make size of excel sheet
			sheet1.setColumnWidth(0,10000);
			sheet1.setColumnWidth(9,10000);
			
		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        
		        for(String value:myReader.getData(stream)) {
		        	System.out.println(value);
		        }
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


