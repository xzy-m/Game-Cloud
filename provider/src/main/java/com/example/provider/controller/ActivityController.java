package com.example.provider.controller;

import com.example.common.entity.Activity;
import com.example.provider.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @author XRS
 * @date 2025-03-25 下午 4:19
 */

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activity/getById")
    public Activity getById(@RequestParam("id") BigInteger id) {
        return activityService.getById(id);
    }

    @RequestMapping("/activity/extractById")
    public Activity extractById(@RequestParam("id") BigInteger id) {
        return activityService.extractById(id);
    }

    @RequestMapping("/activity/insert")
    public int insert(@RequestBody Activity activity) {
        return activityService.insert(activity);
    }

    @RequestMapping("/activity/update")
    public int update(@RequestBody Activity activity) {
        return activityService.update(activity);
    }

    @RequestMapping("/activity/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return activityService.delete(id);
    }

    @RequestMapping("/activity/getAll")
    public List<Activity> getAll() {
        return activityService.getAll();
    }

}
