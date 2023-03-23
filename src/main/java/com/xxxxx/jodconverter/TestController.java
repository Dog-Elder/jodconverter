//package com.xxxxx.jodconverter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//
///**
// * @author shanhy
// * @date 2020/12/16 17:14
// */
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @Autowired
//    private JodConvertService officeConvertService;
//
//    @GetMapping("/test1")
//    public boolean test1(String sourceFileName, String targetFileName) {
//        File sourceFile = new File("D:\\Work\\test\\1111.xlsx");
//        File targetFile = new File("D:\\Work\\test\\1111.pdf");
//        return officeConvertService.convertExcelToPDFByFitColumn(sourceFile, targetFile);
//    }
//}
//
