package test.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritePicToExcel07 {
	public static void main(String[] args) throws Exception {
		/* 写EXCEL，将目标excel中图片写入到新的excel中 */
		String basePath = "C:\\Documents and Settings\\Administrator\\桌面\\";

		Workbook wb = new XSSFWorkbook();

		FileInputStream fis = new FileInputStream(basePath + "img_0.jpeg");
		byte[] bytes = IOUtils.toByteArray(fis);
		int pictureIdx = wb.addPicture(bytes, wb.PICTURE_TYPE_JPEG);
		fis.close();

		Sheet sheet = wb.createSheet("sheet1");
		// 创建一个顶级容器
		Drawing drawing = sheet.createDrawingPatriarch();
		CreationHelper helper = wb.getCreationHelper();
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(3);
		anchor.setRow1(2);
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		// auto-size picture relative to its top-left corner
		pict.resize();// 该方法只支持JPEG 和 PNG后缀文件
		String file = "生成的EXCEL.xls";
		if (wb instanceof XSSFWorkbook)
			file += "x";
		FileOutputStream fos = new FileOutputStream(basePath + file);

		// Row row = sheet.createRow(0);//生成第一行
		// row.createCell(0).setCellValue("A");
		// row.createCell(1).setCellValue("B");
		wb.write(fos);
		fos.close();
	}
}
