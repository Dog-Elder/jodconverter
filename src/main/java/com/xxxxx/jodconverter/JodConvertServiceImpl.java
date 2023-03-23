//package com.xxxxx.jodconverter;
//
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//import com.sun.star.io.IOException;
//import org.apache.poi.ss.usermodel.PrintSetup;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.jodconverter.core.DocumentConverter;
//import org.jodconverter.core.office.OfficeException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.UUID;
//
///**
// * Office转换为PDF
// *
// * @author shanhy
// * @date 2020/12/16 16:58
// */
//@Service
//
//public class JodConvertServiceImpl implements JodConvertService {
//
//    /**
//     * 转换器注入
//     */
//    @Autowired
//    private DocumentConverter converter;
//
//    public boolean convert(File sourceFile, File targetFile) {
//        try {
//            converter.convert(sourceFile).to(targetFile).execute();
//            return true;
//        } catch (OfficeException e) {
//        }
//        return false;
//    }
//
//
//    public boolean convertExcelToPDFByFitColumn(File sourceFile, File targetFile) {
//        String uuid = UUID.randomUUID().toString();
//        File tempExcel = new File(sourceFile.getParentFile(), uuid.concat("_").concat(sourceFile.getName()));
//        try {
//            setExcelPrintParameter(sourceFile, tempExcel);
//            return this.convert(tempExcel, targetFile);
//        } catch (IOException | InvalidFormatException e) {
//        } finally {
//            if (tempExcel.exists() && !tempExcel.delete()){
//                System.out.println("tempExcel = " + tempExcel);
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 设置Excel打印参数
//     *
//     * @param sourceFile
//     * @param targetFile
//     * @throws IOException
//     * @throws InvalidFormatException
//     */
//    private void setExcelPrintParameter(File sourceFile, File targetFile) throws IOException, InvalidFormatException {
//        Workbook workbook = null;
//        try {
//            workbook = new XSSFWorkbook(sourceFile);
//        } catch (java.io.IOException e) {
//            throw new RuntimeException(e);
//        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
//            throw new RuntimeException(e);
//        }
//        for (int i = 0, j = workbook.getNumberOfSheets(); i < j; i++) {
//            Sheet sheet = workbook.getSheetAt(i);
//            sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
//            // FitHeight=1, 将所有行都缩放显示在一页上（设置1表示一页显示完，如果设置2表示分2页显示完）
//            // FitWidth=1, 将所有列都缩放显示在一页上
//            // 两个都等于1时，如果行数太多则会挤压列，一般来说只设置一个FitWidth=1，让行数自动换页
//            // 要使这两个参数有效，则需要设置FitToPage=true
//            sheet.setFitToPage(true);
//            sheet.getPrintSetup().setFitWidth((short) 1);
////          sheet.getPrintSetup().setFitHeight((short)1);
//            // 是否显示自动换页符
//            sheet.setAutobreaks(true);
//        }
//        try (FileOutputStream out = new FileOutputStream(targetFile)) {
//            workbook.write(out);
//            workbook.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (java.io.IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
//
