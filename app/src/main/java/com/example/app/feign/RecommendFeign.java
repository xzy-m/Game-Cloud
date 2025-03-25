package com.example.app.feign;

import com.example.common.entity.Recommend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 5:02
 */

@FeignClient(name = "provider", contextId = "RecommendFeign")
public interface RecommendFeign {

    @RequestMapping("/recommend/getById")
    Recommend getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/recommend/extractById")
    Recommend extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/recommend/insert")
    int insert(@RequestBody Recommend recommend);

    @RequestMapping("/recommend/update")
    int update(@RequestBody Recommend recommend);

    @RequestMapping("/recommend/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/recommend/getAll")
    List<Recommend> getAll();
}
