package com.example.consumer.feign;

import com.example.common.entity.Category;
import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:38
 */

@FeignClient(name = "provider", contextId = "CategoryFeign")
public interface CategoryFeign {
    @RequestMapping("/info")
    Category getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/extractInfo")
    Category extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/insert")
    Response insert(@RequestParam("type") String type,
                    @RequestParam("parentId") BigInteger parentId);

    @RequestMapping("/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("type") String type,
                    @RequestParam("parentId") BigInteger parentId);

    @RequestMapping("/delete")
    Response delete(@RequestParam("id") BigInteger id);
}
