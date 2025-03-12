package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.ConsoleLoginFeign;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:55
 */

@RestController
public class ConsoleLoginController {

    @Autowired
    private ConsoleLoginFeign consoleLoginFeign;

    @RequestMapping("/console/user/login")
    Response logIn(@RequestParam("phone") String phone,
                   @RequestParam("password") String password,
                   HttpServletResponse servletResponse) {
        return consoleLoginFeign.logIn(phone, password, servletResponse);
    }


    @RequestMapping("/console/user/register")
    Response register(@RequestParam("phone") String phone,
                      @RequestParam("password") String password) {
        return consoleLoginFeign.register(phone, password);
    }
}
