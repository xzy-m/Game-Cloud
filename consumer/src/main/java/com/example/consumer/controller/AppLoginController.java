package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.AppLoginFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:36
 */

@RestController
public class AppLoginController {

    @Autowired
    private AppLoginFeign appLoginFeign;

    @RequestMapping("/app/user/login")
    Response logIn(@RequestParam("phone") String phone,
                   @RequestParam("password") String password) {
        return appLoginFeign.logIn(phone, password);
    }

    @RequestMapping("/app/user/register")
    Response register(@RequestParam("phone") String phone,
                      @RequestParam("password") String password) {
        return appLoginFeign.register(phone, password);
    }
}
