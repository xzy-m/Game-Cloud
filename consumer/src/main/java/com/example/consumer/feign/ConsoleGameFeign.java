package com.example.consumer.feign;

import com.example.common.annotation.DataSource;
import com.example.common.enums.DBTypeEnum;
import com.example.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-13 上午 4:45
 */

@FeignClient(name = "provider", contextId = "ConsoleGameFeign")
public interface ConsoleGameFeign {
    @RequestMapping("/console/game/categoryTree")
    Response categoryTree();

    @DataSource(type = DBTypeEnum.SLAVE2)
    @RequestMapping("/console/game/insert")
    Response insert(@RequestParam("pictures") String pictures,
                    @RequestParam("title") String title,
                    @RequestParam("downloadLink") String downloadLink,
                    @RequestParam("categoryId") BigInteger categoryId,
                    @RequestParam("detail") String detail,
                    @RequestParam("tags") String tags);

    @RequestMapping("/console/game/update")
    Response update(@RequestParam("id") BigInteger id,
                    @RequestParam("pictures") String pictures,
                    @RequestParam("title") String title,
                    @RequestParam("downloadLink") String downloadLink,
                    @RequestParam("categoryId") BigInteger categoryId,
                    @RequestParam("detail") String detail,
                    @RequestParam("tags") String tags);

    @RequestMapping("/console/game/delete")
    Response delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/console/game/page")
    Response pagination(@RequestParam("page") int page,
                        @RequestParam(value = "title", required = false) String title);
}
