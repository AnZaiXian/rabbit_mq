package com.bw.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/8/3.
 * A、B、C三个队列绑定到Fanout交换机上面，
 * 发送端的routing_key写任何字符都会被忽略
 *
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send() {
         String context = "hi, fanout msg ";
         System.out.println("Sender : " + context);
         this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

}