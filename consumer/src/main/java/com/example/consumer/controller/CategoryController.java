package com.example.consumer.controller;

import com.example.common.entity.Category;
import com.example.common.response.Response;
import com.example.consumer.feign.CategoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:40
 */

@RestController
public class CategoryController {

    @Autowired
    private CategoryFeign categoryFeign;

    @RequestMapping("/info")
    Category getById(@RequestParam("id") BigInteger id) {
        return categoryFeign.getById(id);
    }

    @RequestMapping("/extractInfo")
    Category extractById(@RequestParam("id") BigInteger id) {
        return categoryFeign.extractById(id);
    }

    @RequestMapping("/insert")
    Response insert(@RequestParam("type") String type,
                    @RequestParam("parentId") BigInteger parentId) {
        return categoryFeign.insert(type, parentId);
    }

    @RequestMapping("/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("type") String type,
                    @RequestParam("parentId") BigInteger parentId) {
        return categoryFeign.update(id, type, parentId);
    }

    @RequestMapping("/delete")
    Response delete(@RequestParam("id") BigInteger id) {
        return categoryFeign.delete(id);
    }

}
