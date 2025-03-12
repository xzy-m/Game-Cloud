package com.example.consumer.controller;

import com.example.common.response.Response;
import com.example.consumer.feign.AppGameFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 2:17
 */

@RestController
public class AppGameController {

    @Autowired
    private AppGameFeign appGameFeign;

    @RequestMapping("/app/game/categories/level1and2")
    Response categoryLevel1And2() {
        return appGameFeign.categoryLevel1And2();
    }

    @RequestMapping("/app/game/categories/level3")
    Response categoryLevel3AndAbove(BigInteger id) {
        return appGameFeign.categoryLevel3AndAbove(id);
    }

    @RequestMapping("/app/game/info")
    Response gameInfo(@RequestParam("id") BigInteger id) {
        return appGameFeign.gameInfo(id);
    }

    @RequestMapping("/app/game/page")
    Response appPagination(@RequestParam(value = "title", required = false) String title,
                           @RequestParam(value = "wp", required = false) String wp) {
        return appGameFeign.appPagination(title, wp);
    }

    @RequestMapping("/app/game/homePage")
    Response homePage() {
        return appGameFeign.homePage();
    }
}
