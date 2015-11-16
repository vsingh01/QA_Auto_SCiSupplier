package com.primerevenue.osci.pageobjects.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.primerevenue.osci.utils.SeleniumUtils;

public class PDFManager {
	
	
	    
		   private PDFParser parser;
		   private PDFTextStripper pdfStripper;
		   private PDDocument pdDoc ;
		   private COSDocument cosDoc ;
		   
		   private String Text ;
		   private String filePath;
		   private File file;
		 
		    public PDFManager() {
		        
		    }
		   public String ToText() throws IOException
		   {
		       this.pdfStripper = null;
		       this.pdDoc = null;
		       this.cosDoc = null;
		       File file = SeleniumUtils.getTheNewestFile("C:/Users/samuluru/Downloads", "PDF");
		       //file = new File(file);
		       parser = new PDFParser(new FileInputStream(file));
		       
		       parser.parse();
		       cosDoc = parser.getDocument();
		       pdfStripper = new PDFTextStripper();
		       pdDoc = new PDDocument(cosDoc);
		       pdDoc.getNumberOfPages();
		       pdfStripper.setStartPage(1);
		       pdfStripper.setEndPage(10);
		       // reading text from page 1 to 10
		       // if you want to get text from full pdf file use this code
		       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
		       
		       Text = pdfStripper.getText(pdDoc);
		       return Text;
		   }
		 
		    public void setFilePath() {
		        this.file = file;
		    }
		    
		    
		    
}

