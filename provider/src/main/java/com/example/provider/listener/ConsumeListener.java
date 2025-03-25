package com.example.provider.listener;

import com.example.common.constant.RabbitMQConstant;
import com.example.provider.mapper.GameMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author XRS
 * @date 2025-03-21 下午 11:50
 */

@Slf4j
@Component
public class ConsumeListener {

    @Autowired
    private GameMapper gameMapper;

    //在消费者这指定队列
    @RabbitHandler
    @RabbitListener(queues = RabbitMQConstant.DirectQueue1)
    public void rabbitMQListener(String message) {
        BigInteger id = null;
        try {
            id = new ObjectMapper().readValue(message, BigInteger.class);
            log.info("MQ接受了消息并执行了后续");
            gameMapper.deleteByCategoryId(id);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
