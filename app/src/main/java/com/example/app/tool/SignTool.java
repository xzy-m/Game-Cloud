package com.example.app.tool;

import com.alibaba.fastjson.JSON;
import com.example.app.feign.UserFeign;
import com.example.common.entity.user.UserSign;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Base64;


/**
 * @author XRS
 * @date 2024-09-15 上午 5:18
 */
public class SignTool {

    @Autowired
    private static UserFeign userFeign;

    private SignTool() {
        throw new RuntimeException("此仅处理app登录注册所需sign用");
    }

    /*
    标志盐和密码盐是干什么的？
     */
    private final static String SIGN_SALT = "FU";
    private static final String PASSWORD_SALT = "M3";

    public static String getSignByUserId(BigInteger userId) {
        //根据当前时间生成时间戳+1000
        int expiration = (int) (System.currentTimeMillis() / 1000 + 259200);

        //为了一个sign特地添了一个类
        UserSign sign = new UserSign();
        sign.setUserId(userId)
                .setExpiration(expiration)
                .setSalt(SIGN_SALT);

        //将这个sign类通过base64转为String
        byte[] bytes = JSON.toJSONString(sign).getBytes();
        String signString = Base64.getUrlEncoder().encodeToString(bytes);

        return signString;
    }

    public static boolean checkSign(String sign) {
        //sign传没传
        if (sign == null) {
            return false;
        }

        byte[] decode = Base64.getUrlDecoder().decode(sign);
        UserSign userSign = null;
        try {
            userSign = JSON.parseObject(new String(decode), UserSign.class);
        } catch (Exception e) {
            throw new RuntimeException("sign凭证解编码时出错请检查");
        }

        //解不解地出来
        if (userSign == null) {
            return false;
        }

        //有没有这个用户
        BigInteger userId = userSign.getUserId();
        if (userFeign.extractById(userId) == null) {
            return false;
        }

        //过没过期
        Integer expiration = userSign.getExpiration();
        int current = (int) (System.currentTimeMillis() / 1000);
        if (current > expiration) {
            return false;
        }

        return true;
    }
}
