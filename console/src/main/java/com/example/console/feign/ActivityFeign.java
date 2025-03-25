package com.example.console.feign;

import com.example.common.entity.Activity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:20
 */

@FeignClient(name = "provider", contextId = "ActivityFeign")
public interface ActivityFeign {

    @RequestMapping("/activity/getById")
    Activity getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/activity/extractById")
    Activity extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/activity/insert")
    int insert(@RequestBody Activity activity);

    @RequestMapping("/activity/update")
    int update(@RequestBody Activity activity);

    @RequestMapping("/activity/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/activity/getAll")
    List<Activity> getAll();
}
