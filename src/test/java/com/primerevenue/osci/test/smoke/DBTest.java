package com.primerevenue.osci.test.smoke;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.primerevenue.osci.pageobjects.common.PDFManager;
import com.primerevenue.osci.utils.SeleniumUtils;





public class DBTest {
	
	/*@Test
	public void dbtest() throws InterruptedException {
		
		//String filePath = "C:/Users/samuluru/Downloads/SupplierTradingTrendsReport_201511140511.pdf";
		
		File filePath = SeleniumUtils.getTheNewestFile("C:/Users/samuluru/Downloads", "txt");
       
		//File file = new File(filePath);
		
		BufferedReader br = null;
		
		try {
			FileReader fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			
			String line;
			
			while( (line = br.readLine()) != null )	{
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found:"+ filePath.toString());
			
		} catch (IOException e)	{
			System.out.println("unable to read file:"+ filePath.toString());
		}

		try {
			br.close();
				
		} catch (IOException e)	{
			System.out.println("unable to close the  file:"+ filePath.toString());
		}
}*/
	@Test()	
	public void pdftest() throws IOException	{
		
		//File newestFile = SeleniumUtils.getTheNewestFile("C:/Users/samuluru/Downloads", "PDF");
	PDFManager pdfManager = new PDFManager();
	pdfManager.setFilePath();
	
    System.out.println(pdfManager.ToText()); 	
    
	}
	
}
	
	
	

	
	

