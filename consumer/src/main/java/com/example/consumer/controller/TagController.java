package com.example.consumer.controller;

import com.example.common.entity.Tag;
import com.example.common.response.Response;
import com.example.consumer.feign.TagFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:14
 */

@RestController
public class TagController {

    @Autowired
    private TagFeign tagFeign;

    @RequestMapping("/tag/info")
    Tag getById(@RequestParam("id") BigInteger id) {
        return tagFeign.getById(id);
    }

    @RequestMapping("/tag/extractInfo")
    Tag extractById(@RequestParam("id") BigInteger id) {
        return tagFeign.extractById(id);
    }

    @RequestMapping("/tag/insert")
    Response insert(@RequestParam("name") String name) {
        return tagFeign.insert(name);
    }

    @RequestMapping("/tag/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("name") String name) {
        return tagFeign.update(id, name);
    }

    @RequestMapping("/tag/delete")
    Response delete(@RequestParam("id") BigInteger id) {
        return tagFeign.delete(id);
    }
}
