package com.example.console.controller;

import com.example.common.entity.Category;
import com.example.common.response.Response;
import com.example.console.feign.CategoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2024-08-08 下午 2:48
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    public CategoryFeign categoryFeign;

    @RequestMapping("/info")
    public Category getById(@RequestParam("id") BigInteger id) {
        return categoryFeign.getById(id);
    }

    @RequestMapping("/extractInfo")
    public Category extractById(@RequestParam("id") BigInteger id) {
        return categoryFeign.extractById(id);
    }

    @RequestMapping("/insert")
    public Response insert(@RequestParam("type") String type,
                           @RequestParam("parentId") BigInteger parentId) {
        try {
            String statusCode = categoryFeign.insertOrUpdate(null, type, parentId) != null ? "1001" : "1003";
            Response response = new Response(statusCode);
            return response;
        } catch (Exception e) {
            Response response = new Response("1004");
            return response;
        }
    }

    @RequestMapping("/update")
    public Response update(@RequestParam("id") BigInteger id,
                           @RequestParam("type") String type,
                           @RequestParam("parentId") BigInteger parentId) {
        try {
            String statusCode = categoryFeign.insertOrUpdate(id, type, parentId) != null ? "1001" : "1003";
            Response response = new Response(statusCode);
            return response;
        } catch (Exception e) {
            Response response = new Response("1004");
            return response;
        }
    }

    @RequestMapping("/delete")
    public Response delete(@RequestParam("id") BigInteger id) {

        String statusCode = categoryFeign.delete(id) != 0 ? "1001" : "1003";
        Response response = new Response(statusCode);

        return response;
    }
}
