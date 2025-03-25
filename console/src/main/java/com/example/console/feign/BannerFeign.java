package com.example.console.feign;

import com.example.common.entity.Banner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:28
 */

@FeignClient(name = "provider", contextId = "BannerFeign")
public interface BannerFeign {
    @RequestMapping("/banner/getById")
    Banner getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/banner/extractById")
    Banner extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/banner/insert")
    int insert(@RequestBody Banner banner);

    @RequestMapping("/banner/update")
    int update(@RequestBody Banner banner);

    @RequestMapping("/banner/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/banner/getAll")
    List<Banner> getAll();
}
