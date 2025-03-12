package com.example.consumer.feign;

import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:20
 */

@FeignClient(name = "provider", contextId = "UploadFeign")
public interface UploadFeign {

    @RequestMapping("/local/image")
    Response uploadLocal(@RequestParam("image") MultipartFile image);

    @RequestMapping("/oss/image")
    Response uploadOss(@RequestParam("image") MultipartFile image);
}
