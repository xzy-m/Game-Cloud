package com.example.app.feign;

import com.example.common.entity.Sms;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:12
 */

@FeignClient(name = "provider", contextId = "SmsFeign")
public interface SmsFeign {

    @RequestMapping("/sms/getById")
    Sms getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/sms/extractById")
    Sms extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/sms/insert")
    int insert(@RequestBody Sms sms);

    @RequestMapping("/sms/update")
    int update(@RequestBody Sms sms);

    @RequestMapping("/sms/delete")
    int delete(@RequestParam("id") BigInteger id,
               @RequestParam("version") Integer version);
}
