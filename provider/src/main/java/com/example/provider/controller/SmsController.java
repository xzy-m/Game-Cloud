package com.example.provider.controller;

import com.example.common.entity.Sms;
import com.example.provider.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-25 下午 5:07
 */
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("/sms/getById")
    public Sms getById(@RequestParam("id") BigInteger id) {
        return smsService.getById(id);
    }

    @RequestMapping("/sms/extractById")
    public Sms extractById(@RequestParam("id") BigInteger id) {
        return smsService.extractById(id);
    }

    @RequestMapping("/sms/insert")
    public int insert(@RequestBody Sms sms) {
        return smsService.insert(sms);
    }

    @RequestMapping("/sms/update")
    public int update(@RequestBody Sms sms) {
        return smsService.update(sms);
    }

    @RequestMapping("/sms/delete")
    public int delete(@RequestParam("id") BigInteger id,
                      @RequestParam("version") Integer version) {
        return smsService.delete(id, version);
    }
}
