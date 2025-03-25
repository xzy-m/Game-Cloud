package com.example.provider.controller;

import com.example.common.entity.Channel;
import com.example.provider.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:44
 */

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @RequestMapping("/channel/getById")
    public Channel getById(@RequestParam("id") BigInteger id) {
        return channelService.getById(id);
    }

    @RequestMapping("/channel/extractById")
    public Channel extractById(@RequestParam("id") BigInteger id) {
        return channelService.extractById(id);
    }

    @RequestMapping("/channel/insert")
    public int insert(@RequestBody Channel channel) {
        return channelService.insert(channel);
    }

    @RequestMapping("/channel/update")
    public int update(@RequestBody Channel channel) {
        return channelService.update(channel);
    }

    @RequestMapping("/channel/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return channelService.delete(id);
    }

    @RequestMapping("/channel/getAll")
    public List<Channel> getAll() {
        return channelService.getAll();
    }

}
