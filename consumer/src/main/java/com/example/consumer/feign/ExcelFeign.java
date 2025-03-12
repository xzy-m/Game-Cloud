package com.example.consumer.feign;

import com.example.common.response.Response;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:10
 */

@FeignClient(name = "provider", contextId = "ExcelFeign")
public interface ExcelFeign {
    @RequestMapping("/excel/read")
    Response readExcel(HttpServletResponse response);

    @RequestMapping("/excel/write")
    Response writeExcel(@RequestParam("file") MultipartFile file);
}
