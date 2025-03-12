package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.SmsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:12
 */

//@RestController
public class SmsController {

    @Autowired
    private SmsFeign smsFeign;

    @RequestMapping("/sms/send")
    Response sendMessage(String phoneNumbers, String conference, String address, String time) {
        return smsFeign.sendMessage(phoneNumbers, conference, address, time);
    }
}
