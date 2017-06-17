package test.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PictureData;

import com.sun.media.sound.InvalidFormatException;
  
public class ReadPicturesFromExcel {  
  
    public static void main(String[] args) throws InvalidFormatException,  
            Exception {  
  
        InputStream inp = new FileInputStream(  
                "F:\\test.xls");  
        HSSFWorkbook workbook = new HSSFWorkbook(inp);//(HSSFWorkbook) WorkbookFactory.create(inp);  
  
        List<HSSFPictureData> pictures = workbook.getAllPictures();  
        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);  
          
          
        int i = 0;  
        for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {  
            HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();  
  
            if (shape instanceof HSSFPicture) {  
                HSSFPicture pic = (HSSFPicture) shape;  
                int row = anchor.getRow1();  
                System.out.println(i + "--->" + anchor.getRow1() + ":"  
                        + anchor.getCol1());  
                int pictureIndex = pic.getPictureIndex()-1;  
                HSSFPictureData picData = pictures.get(pictureIndex);  
  
                System.out.println(i + "--->" + pictureIndex);  
                savePic(row, picData);  
            }  
            i++;  
        }  
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
