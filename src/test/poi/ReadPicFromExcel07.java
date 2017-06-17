package test.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadPicFromExcel07 {
	public static void main(String[] args) throws Exception {
		/* 读EXCEL图片，将excel中的图片保存到桌面上 */
		String basePath = "C:\\Documents and Settings\\Administrator\\桌面\\";
		FileInputStream fis = new FileInputStream(basePath + "pic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		List<XSSFPictureData> pictures = workbook.getAllPictures();
		for (int i = 0; i < pictures.size(); i++) {
			XSSFPictureData pictureData = pictures.get(i);
			byte[] data = pictureData.getData();
			String ext = pictureData.suggestFileExtension();// 获取扩展名

			FileOutputStream out = new FileOutputStream(basePath + "img_" + i
					+ "." + ext);
			out.write(data);
			out.close();
		}/* 读EXCEL图片完毕 */

		/* 读EXCEL文字内容 */
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		Row row;
		Cell cell;
		while (rows.hasNext()) {
			row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				cell = cells.next();
				System.out.println("RowIndex:" + cell.getRowIndex());
				System.out.println("ColumnIndex:" + cell.getColumnIndex());
				System.out.println("值:" + cell.getStringCellValue());
			}
		}
		/*
		 * 图片在excel中，并不属于excel表格中的元素，可以理解为浮在表格上面，无法定格在表格中。
		 */
	}
}
