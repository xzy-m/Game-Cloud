package com.example.app.controller;

import com.example.app.feign.SmsFeign;
import com.example.app.tool.SmsTool;
import com.example.common.entity.Sms;
import com.example.common.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * @author XRS
 * @date 2024-10-11 下午 3:32
 */
@RestController
public class SmsController {

    @Autowired
    private SmsFeign smsFeign;

    @Autowired
    private SmsTool smsTool;

    @RequestMapping("/sms/send")
    public Response sendMessage(String phoneNumbers, String conference, String address, String time) {

        Sms sms = new Sms();
        String content = "温馨提醒：" + conference + "会议将在" + address + "地点，于" + time + "时间开始，请您准时参加。";
        try {
            Response response = smsTool.sendMessage(phoneNumbers, conference, address, time);
            sms.setPhone(phoneNumbers).setContent(content).setResult((String) response.getData());
        } catch (ExecutionException e) {
            return new Response("1004");
        } catch (InterruptedException e) {
            return new Response("1004");
        }

        int result = smsFeign.insert(sms);
        return result == 1 ? new Response("1001") : new Response("1002");
    }

    @RequestMapping("/sms/update")
    public Response updateMessage(BigInteger id, String content, Integer version) {
        Sms sms = new Sms().setId(id).setContent(content).setVersion(version);
        int update = smsFeign.update(sms);
        return update == 1 ? new Response("1001") : new Response("1002");
    }
}
