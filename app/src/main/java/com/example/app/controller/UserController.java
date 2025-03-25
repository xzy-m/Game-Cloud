package com.example.app.controller;

import com.example.app.feign.UserFeign;
import com.example.common.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-25 下午 3:53
 */
public class UserController {

    @Autowired
    private UserFeign userFeign;

    public User getById(BigInteger id) {
        return userFeign.getById(id);
    }

    public User extractById(BigInteger id) {
        return userFeign.extractById(id);
    }

    public int insert(User user) {
        return userFeign.insert(user);
    }

    public int update(User user) {
        return userFeign.update(user);
    }

    public int delete(BigInteger id) {
        return userFeign.delete(id);
    }

    public User selectByPhoneAndPwd(String phone, String password) {
        return userFeign.selectByPhoneAndPwd(phone, password);
    }

    public BigInteger insertOrUpdate(BigInteger id, String phone, String password) {
        return userFeign.insertOrUpdate(id, phone, password);
    }

    public User selectByPhone(String phone) {
        return userFeign.selectByPhone(phone);
    }

    public boolean accountCheck(String phone, String password256) {
        return userFeign.accountCheck(phone, password256);
    }

}
