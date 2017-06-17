package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

public class ReadPdf {
	 public static String getTextFromPDF(String pdfFilePath){  
	        String result = null;  
	        FileInputStream is = null;  
	        PDDocument document = null;  
	        try {  
	            is = new FileInputStream(pdfFilePath);  
	            PDFParser parser = new PDFParser(is);  
	            parser.parse();  
	            document = parser.getPDDocument();  
	            PDFTextStripper stripper = new PDFTextStripper();  
	            result = stripper.getText(document);  
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } finally {  
	            if (is != null) {  
	                try {  
	                    is.close();  
	                } catch (IOException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (document != null) {  
	                try {  
	                    document.close();  
	                } catch (IOException e) {  
	                    // TODO Auto-generated catch block  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return result;  
	    }  
	    public  static void main(String[] args)  
	    {  
	        String str=ReadPdf.getTextFromPDF("C:\\Users\\caoyan\\Desktop\\11.pdf");  
	        System.out.println(str);  
	      
	    }  
}
