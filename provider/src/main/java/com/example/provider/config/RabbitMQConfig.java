package com.example.provider.config;

import com.example.common.constant.RabbitMQConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XRS
 * @date 2025-03-21 下午 10:04
 */

@Configuration
public class RabbitMQConfig {

    //Constants是常量类  DIRECT_QUEUE1是一个常量
    @Bean("directQueue1")
    public Queue directQueue1() {
        return QueueBuilder.durable(RabbitMQConstant.DirectQueue1).build();
    }

    @Bean("directQueue2")
    public Queue directQueue2() {
        return QueueBuilder.durable(RabbitMQConstant.DirectQueue2).build();
    }

    @Bean("directExchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(RabbitMQConstant.DirectExchange).durable(true).build();
    }

    @Bean("queueExchangeBinding1")
    public Binding queueExchangeBinding1(@Qualifier("directQueue1") Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("game");
    }

    @Bean("queueExchangeBinding2")
    public Binding queueExchangeBinding2(@Qualifier("directQueue2")Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("category");
    }

    //MQ中生产者和消费者传递消息的类型有限   需要再处理   序列化和反序列化
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
