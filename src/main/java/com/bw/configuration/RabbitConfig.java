package com.bw.configuration;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by lenovo on 2017/8/3.
 * 队列的配置 : 相当于中间件
 *
 */

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {

        return new Queue("hello");
    }

    @Bean
    public Queue noe() {

        return new Queue("noe");
    }

    @Bean
    public Queue jec() {

        return new Queue("object");
    }


}
