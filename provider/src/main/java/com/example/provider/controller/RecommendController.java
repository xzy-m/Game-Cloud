package com.example.provider.controller;

import com.example.common.entity.Recommend;
import com.example.provider.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 5:00
 */

@RestController
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping("/recommend/getById")
    public Recommend getById(@RequestParam("id") BigInteger id) {
        return recommendService.getById(id);
    }

    @RequestMapping("/recommend/extractById")
    public Recommend extractById(@RequestParam("id") BigInteger id) {
        return recommendService.extractById(id);
    }

    @RequestMapping("/recommend/insert")
    public int insert(@RequestBody Recommend recommend) {
        return recommendService.insert(recommend);
    }

    @RequestMapping("/recommend/update")
    public int update(@RequestBody Recommend recommend) {
        return recommendService.update(recommend);
    }

    @RequestMapping("/recommend/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return recommendService.delete(id);
    }

    @RequestMapping("/recommend/getAll")
    public List<Recommend> getAll() {
        return recommendService.getAll();
    }
}
