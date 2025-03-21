package com.example.provider.listener;

import com.example.provider.mapper.GameMapper;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author XRS
 * @date 2025-03-21 下午 11:50
 */

@Component
public class RabbitListener {

    @Autowired
    private GameMapper gameMapper;

    @RabbitHandler
    @RabbitListener
    public void rabbitListener(){

    }

    @RabbitHandler
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queuesToDeclare = @Queue("game"))
    public void consume(String message) {
    }
}
