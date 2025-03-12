package com.example.consumer.feign;

import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 2:09
 * 虽然 name 属性用于指定服务名称，
 * 但 Feign 客户端接口本身在 Spring 容器中也会被注册为 Bean。
 * 因此，每个 Feign 客户端接口的全限定名需要唯一
 */

@FeignClient(name = "provider", contextId = "AppGameFeign")
public interface AppGameFeign {
    @RequestMapping("/app/game/categories/level1and2")
    Response categoryLevel1And2();

    @RequestMapping("/app/game/categories/level3")
    Response categoryLevel3AndAbove(BigInteger id);

    @RequestMapping("/app/game/info")
    Response gameInfo(@RequestParam("id") BigInteger id);

    @RequestMapping("/app/game/page")
    Response appPagination(@RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "wp", required = false) String wp);

    @RequestMapping("/app/game/homePage")
    Response homePage();
}
