package test.csv;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;

public class CsvReaderExample {
	public static void main(String[] args) {
		try {
			
			CsvReader products = new CsvReader("users.csv");
		
			products.readHeaders();

			while (products.readRecord())
			{
//				String productID = products.get("ProductID");
//				String productName = products.get("ProductName");
//				String supplierID = products.get("SupplierID");
//				String categoryID = products.get("CategoryID");
//				String quantityPerUnit = products.get("QuantityPerUnit");
//				String unitPrice = products.get("UnitPrice");
//				String unitsInStock = products.get("UnitsInStock");
//				String unitsOnOrder = products.get("UnitsOnOrder");
//				String reorderLevel = products.get("ReorderLevel");
//				String discontinued = products.get("Discontinued");
				String id = products.get("id");
				String name = products.get("name");
				
				// perform program logic here
				System.out.println(id + ":" + name);
			}
	
			products.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
