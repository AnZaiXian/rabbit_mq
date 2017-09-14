package com.bw.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lenovo on 2017/8/3.
 * 发送者
 */
@Component
public class NeoSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Integer i) {
        String context = "hello ===>>" + i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("noe", context);
    }

    }
