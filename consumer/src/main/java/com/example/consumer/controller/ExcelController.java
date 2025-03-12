package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.ExcelFeign;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:09
 */

@RestController
public class ExcelController {

    @Autowired
    private ExcelFeign excelFeign;

    @RequestMapping("/excel/read")
    Response readExcel(HttpServletResponse response) {
        return excelFeign.readExcel(response);
    }

    @RequestMapping("/excel/write")
    Response writeExcel(@RequestParam("file") MultipartFile file) {
        return excelFeign.writeExcel(file);
    }
}
