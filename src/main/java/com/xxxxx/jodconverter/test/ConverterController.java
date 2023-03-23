package com.xxxxx.jodconverter.test;

import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;


/**
 * Controller providing conversion endpoints.
 */
@Controller
public class ConverterController {

    private static final String ATTRNAME_ERROR_MESSAGE = "errorMessage";
    private static final String ON_ERROR_REDIRECT = "redirect:/";

//    @Autowired
//    private DocumentConverter converter;


    /**
     * Converts a souirce file to a target format.

     */
    @PostMapping("/converter")
    @ResponseBody
    public Object convert() throws OfficeException {
        OfficeManager officeManager = LocalOfficeManager.builder()
                .install()
                .portNumbers(8089)
                .officeHome("D:\\software\\personal\\LibreOffice")
                .build();
        File sourceFile = new File("D:\\software\\OneDrive\\桌面\\新建 DOCX 文档.docx");
        File targetFile = new File("D:\\software\\OneDrive\\桌面\\新建 DOCX 文档.pdf");
        try {
            // Start an office process and connect to the started instance (on port 2002).
            officeManager.start();
            // Convert
            JodConverter
                    .convert(sourceFile)
                    .to(targetFile)
                    .execute();
        } finally {
            // Stop the office process
            OfficeUtils.stopQuietly(officeManager);
        }
        return ON_ERROR_REDIRECT;
    }


}