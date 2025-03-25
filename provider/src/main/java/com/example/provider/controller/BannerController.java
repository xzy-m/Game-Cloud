package com.example.provider.controller;

import com.example.common.entity.Banner;
import com.example.provider.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:27
 */
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/banner/getById")
    public Banner getById(@RequestParam("id") BigInteger id) {
        return bannerService.getById(id);
    }

    @RequestMapping("/banner/extractById")
    public Banner extractById(@RequestParam("id") BigInteger id) {
        return bannerService.extractById(id);
    }

    @RequestMapping("/banner/insert")
    public int insert(@RequestBody Banner banner) {
        return bannerService.insert(banner);
    }

    @RequestMapping("/banner/update")
    public int update(@RequestBody Banner banner) {
        return bannerService.update(banner);
    }

    @RequestMapping("/banner/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return bannerService.delete(id);
    }

    @RequestMapping("/banner/getAll")
    public List<Banner> getAll() {
        return bannerService.getAll();
    }
}
