package com.example.consumer.feign;

import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:12
 */

//@FeignClient(name = "provider", contextId = "SmsFeign")
public interface SmsFeign {
    @RequestMapping("/sms/send")
    Response sendMessage(String phoneNumbers, String conference, String address, String time);
}
