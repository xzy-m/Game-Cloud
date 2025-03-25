package com.example.app.feign;

import com.example.common.entity.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-25 下午 3:57
 */

@FeignClient(name = "provider", contextId = "UserFeign")
public interface UserFeign {

    @RequestMapping("/user/getById")
    User getById(@RequestParam("id") BigInteger id);

    @RequestMapping("/user/extractById")
    User extractById(@RequestParam("id") BigInteger id);

    @RequestMapping("/user/insert")
    int insert(@RequestBody User user);

    @RequestMapping("/user/update")
    int update(@RequestBody User user);

    @RequestMapping("/user/delete")
    int delete(@RequestParam("id") BigInteger id);

    @RequestMapping("/user/selectByPhoneAndPwd")
    User selectByPhoneAndPwd(@RequestParam("phone") String phone,
                             @RequestParam("password") String password);

    @RequestMapping("/user/insertOrUpdate")
    BigInteger insertOrUpdate(@RequestParam("id") BigInteger id,
                              @RequestParam("phone") String phone,
                              @RequestParam("password") String password);

    @RequestMapping("/user/selectByPhone")
    User selectByPhone(@RequestParam("phone") String phone);

    @RequestMapping("/user/accountCheck")
    boolean accountCheck(@RequestParam("phone") String phone,
                         @RequestParam("password256") String password256);
}
