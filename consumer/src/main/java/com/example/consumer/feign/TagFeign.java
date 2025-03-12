package com.example.consumer.feign;

import com.example.common.entity.Tag;
import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 5:14
 */

@FeignClient(name = "provider", contextId = "TagFeign")
public interface TagFeign {
    @RequestMapping("/tag/info")
    Tag getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/tag/extractInfo")
    Tag extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/tag/insert")
    Response insert(@RequestParam("name") String name);

    @RequestMapping("/tag/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("name") String name);

    @RequestMapping("/tag/delete")
    Response delete(@RequestParam("id") BigInteger id);
}
