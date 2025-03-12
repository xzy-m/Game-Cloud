package com.example.consumer.feign;

import com.example.common.response.Response;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:55
 */

@FeignClient(name = "provider", contextId = "ConsoleLoginFeign")
public interface ConsoleLoginFeign {
    @RequestMapping("/console/user/login")
    Response logIn(@RequestParam("phone") String phone,
                   @RequestParam("password") String password,
                   HttpServletResponse servletResponse);


    @RequestMapping("/console/user/register")
    Response register(@RequestParam("phone") String phone,
                      @RequestParam("password") String password);
}
