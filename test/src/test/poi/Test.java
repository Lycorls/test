package test.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.media.sound.InvalidFormatException;

public class Test {
	public static void main(String[] args) throws InvalidFormatException,
			Exception {

		InputStream inp = new FileInputStream("F:\\test.xlsx");
		Workbook workbook = new XSSFWorkbook(inp);
		List<XSSFPictureData> pictures = (List<XSSFPictureData>) workbook
				.getAllPictures();
		// Sheet sheet = workbook.getSheetAt(0);

		int i = 0;
		for (XSSFPictureData picture : pictures) {
			byte[] data = picture.getData();
			String ext = picture.suggestFileExtension();// 获取扩展名
			FileOutputStream out = new FileOutputStream("F:\\pict222" + i + ".jpg");
			out.write(data);
			out.close();
		}
		System.out.println(123);
	}
}
