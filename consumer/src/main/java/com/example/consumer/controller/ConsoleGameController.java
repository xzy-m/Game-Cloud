package com.example.consumer.controller;

import com.example.common.annotation.DataSource;
import com.example.common.enums.DBTypeEnum;
import com.example.common.response.Response;
import com.example.consumer.feign.ConsoleGameFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:44
 */

@RestController
public class ConsoleGameController {

    @Autowired
    private ConsoleGameFeign consoleGameFeign;

    @RequestMapping("/console/game/categoryTree")
    Response categoryTree() {
        return consoleGameFeign.categoryTree();
    }

    @DataSource(type = DBTypeEnum.SLAVE2)
    @RequestMapping("/console/game/insert")
    Response insert(@RequestParam("pictures") String pictures,
                    @RequestParam("title") String title,
                    @RequestParam("downloadLink") String downloadLink,
                    @RequestParam("categoryId") BigInteger categoryId,
                    @RequestParam("detail") String detail,
                    @RequestParam("tags") String tags) {
        return consoleGameFeign.insert(pictures, title, downloadLink, categoryId, detail, tags);
    }

    @RequestMapping("/console/game/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("pictures") String pictures,
                    @RequestParam("title") String title,
                    @RequestParam("downloadLink") String downloadLink,
                    @RequestParam("categoryId") BigInteger categoryId,
                    @RequestParam("detail") String detail,
                    @RequestParam("tags") String tags) {
        return consoleGameFeign.update(id, pictures, title, downloadLink, categoryId, detail, tags);
    }

    @RequestMapping("/console/game/delete")
    Response delete(@RequestParam("id") BigInteger id) {
        return consoleGameFeign.delete(id);
    }

    @RequestMapping("/console/game/page")
    Response pagination(@RequestParam("page") int page,
                        @RequestParam(value = "title", required = false) String title) {
        return consoleGameFeign.pagination(page, title);
    }
}
