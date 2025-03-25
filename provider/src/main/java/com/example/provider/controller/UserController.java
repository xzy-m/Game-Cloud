package com.example.provider.controller;

import com.example.common.entity.user.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-25 下午 3:47
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/getById")
    public User getById(@RequestParam("id") BigInteger id) {
        return userService.getById(id);
    }

    @RequestMapping("/user/extractById")
    public User extractById(@RequestParam("id") BigInteger id) {
        return userService.extractById(id);
    }

    @RequestMapping("/user/insert")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping("/user/update")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping("/user/delete")
    public int delete(@RequestParam("id") BigInteger id) {
        return userService.delete(id);
    }

    @RequestMapping("/user/selectByPhoneAndPwd")
    public User selectByPhoneAndPwd(@RequestParam("phone") String phone,
                                    @RequestParam("password") String password) {
        return userService.selectByPhoneAndPwd(phone, password);
    }

    @RequestMapping("/user/insertOrUpdate")
    public BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("password") String password) {
        return userService.insertOrUpdate(id, phone, password);
    }

    @RequestMapping("/user/selectByPhone")
    public User selectByPhone(@RequestParam("phone") String phone) {
        return userService.selectByPhone(phone);
    }

    @RequestMapping("/user/accountCheck")
    public boolean accountCheck(@RequestParam("phone") String phone, @RequestParam("password256") String password256) {
        return userService.accountCheck(phone, password256);
    }
}
