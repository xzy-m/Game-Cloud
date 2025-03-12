package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.UploadFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:19
 */
@RestController
public class UploadController {

    @Autowired
    private UploadFeign uploadFeign;

    @RequestMapping("/local/image")
    Response uploadLocal(@RequestParam("image") MultipartFile image) {
        return uploadFeign.uploadLocal(image);
    }

    @RequestMapping("/oss/image")
    Response uploadOss(@RequestParam("image") MultipartFile image) {
        return uploadFeign.uploadOss(image);
    }
}
