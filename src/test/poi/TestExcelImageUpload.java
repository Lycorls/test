//package test.poi;
//
//import java.awt.Image;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//
//public class TestExcelImageUpload {
//	
//	/*
//     * 保存excel中的图片(以文件形式保存，或者存入数据库) 
//     * 
//     * basePath:应用所在路径,附件存放路径:
//     * 参数：is是上传的附件文件流
//     */
//    public void saveSheetImgByFile(String basePath,InputStream is) {
//        FileOutputStream os = null;
//        try {
//            Workbook wbk = Workbook.getWorkbook(is);
//            //建文件目录
//            File mkFile = new File(basePath);
//            if (!mkFile.exists() && !mkFile.isDirectory()) {
//                mkFile.mkdirs();
//            }
//            // 循环所有sheet
//            for (int k = 0; k < wbk.getNumberOfSheets(); k++) {
//                Sheet sheet = wbk.getSheet(k);
//                // 共有多少行
//                int imgNumber = sheet.getNumberOfImages();// 获得sheet所包含的图片数
//                // 循环sheet的所有图片
//                for (int i = 0; i < imgNumber; i++) {
//                    Image image = sheet.getDrawing(i);
//                    byte[] imageData = image.getImageData();
//                    String fileName = image.getImageFile().getName().trim()
//                            + ".jpg";
//                    File file = new File(basePath+"/" + fileName);
//
//                    os = new FileOutputStream(file);// 建立一个上传文件的输出流
//                    os.write(imageData, 0, imageData.length);// 将文件写入服务器
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            try {
//                if (os != null) {
//                    os.close();
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//}
