package com.example.app.feign;

import com.example.common.entity.Channel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:45
 */

@FeignClient(name = "provider", contextId = "ChannelFeign")
public interface ChannelFeign {

    @RequestMapping("/channel/getById")
    Channel getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/channel/extractById")
    Channel extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/channel/insert")
    int insert(@RequestBody Channel channel);

    @RequestMapping("/channel/update")
    int update(@RequestBody Channel channel);

    @RequestMapping("/channel/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/channel/getAll")
    List<Channel> getAll();
}
