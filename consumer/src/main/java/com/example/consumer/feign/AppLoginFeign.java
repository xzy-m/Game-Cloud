package com.example.consumer.feign;

import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:34
 */

@FeignClient(name = "provider", contextId = "AppLoginFeign")
public interface AppLoginFeign {
    @RequestMapping("/app/user/login")
    Response logIn(@RequestParam("phone") String phone,
                          @RequestParam("password") String password);

    @RequestMapping("/app/user/register")
    Response register(@RequestParam("phone") String phone,
                             @RequestParam("password") String password);
}
