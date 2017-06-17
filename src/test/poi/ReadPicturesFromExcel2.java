package test.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.media.sound.InvalidFormatException;
  
public class ReadPicturesFromExcel2 {  
  
    public static void main(String[] args) throws InvalidFormatException,  
            Exception {  
  
        InputStream inp = new FileInputStream(  
                "F:\\test.xlsx");  
        Workbook workbook = new XSSFWorkbook(inp);
        List<XSSFPictureData> pictures = (List<XSSFPictureData>) workbook.getAllPictures();  
        //Sheet sheet =  workbook.getSheetAt(0);  
        
        int i = 0;  
        for (XSSFPictureData picture : pictures) {
        	byte[] data = picture.getData(); 
        	String ext = picture.suggestFileExtension();//获取扩展名
        	FileOutputStream out = new FileOutputStream(  
                    "F:\\pict" + i + ".jpg");  
            out.write(data);  
            out.close();  
		}
        System.out.println(123);
        
//        sheet.getDrawingPatriarch().
//        sheet.getDrawingPatriarch();
//        int i = 0;  
//        sheet.get
//        for (Shape shape : sheet.getDrawingPatriarch().getChildren()) {  
//            HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();  
//  
//            if (shape instanceof HSSFPicture) {  
//            	XSSFPicture pic = (XSSFPicture) shape;  
//                int row = anchor.getRow1();  
//                System.out.println(i + "--->" + anchor.getRow1() + ":"  
//                        + anchor.getCol1());  
//                int pictureIndex = pic.getPictureIndex()-1;  
//                HSSFPictureData picData = pictures.get(pictureIndex);  
//  
//                System.out.println(i + "--->" + pictureIndex);  
//                savePic(row, picData);  
//            }  
//            i++;  
//        }  
    }  
  
    private static void savePic(int i, PictureData pic) throws Exception {  
  
        String ext = pic.suggestFileExtension();  
  
        byte[] data = pic.getData();  
        if (ext.equals("jpeg")) {  
            FileOutputStream out = new FileOutputStream(  
                    "F:\\pict" + i + ".jpg");  
            out.write(data);  
            out.close();  
        }  
        if (ext.equals("png")) {  
            FileOutputStream out = new FileOutputStream(  
                    "F:\\pict" + i + ".png");  
            out.write(data);  
            out.close();  
        }  
    }  
  
} 
