package com.example.provider.service;

import com.example.common.entity.Sms;
import com.example.provider.mapper.SmsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 野狗
 * @since 2024-10-11
 */
@Service
public class SmsService {

    @Resource
    private SmsMapper smsMapper;

    public Sms getById(BigInteger id) {
        return smsMapper.getById(id);
    }

    public Sms extractById(BigInteger id) {
        return smsMapper.extractById(id);
    }

    public int insert(Sms sms) {
        int time = (int) (System.currentTimeMillis() / 1000);
        sms.setTime(time).setCreateTime(time).setUpdateTime(time).setIsDeleted(0);
        return smsMapper.insert(sms);
    }

    public int update(Sms sms) {
        //先查一下有没有这条短信记录
        Sms existingSms = smsMapper.getById(sms.getId());
        if (existingSms == null) {
            throw new RuntimeException("此短信记录不存在~");
        }

        //再查一下短信版本号是否对的上
        if (existingSms.getVersion() != sms.getVersion()) {
            throw new RuntimeException("短信版本对不上，已经被改过了");
        }

        //对的上就改，同时更新一下此条短信的版本号
        sms.setVersion(existingSms.getVersion() + 1);
        int time = (int) (System.currentTimeMillis() / 1000);
        sms.setUpdateTime(time);
        return smsMapper.update(sms);
    }

    public int delete(BigInteger id, Integer version) {
        //先查一下有没有这条短信记录
        Sms existingSms = smsMapper.getById(id);
        if (existingSms == null) {
            throw new RuntimeException("此短信记录不存在~");
        }

        //再查一下短信版本号是否对的上
        if (existingSms.getVersion() != version) {
            throw new RuntimeException("短信版本对不上，已被删");
        }

        //对的上就删，同时更新一下此条短信的版本号
        int time = (int) (System.currentTimeMillis() / 1000);
        return smsMapper.delete(time, id, version);
    }
}
