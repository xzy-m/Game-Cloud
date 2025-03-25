package com.example.common.entity.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class User {
    private BigInteger id;
    private String phone;
    private String password;
    private String rank;
    private Integer updateTime;
    private Integer createTime;
    private Integer isDeleted;
}
