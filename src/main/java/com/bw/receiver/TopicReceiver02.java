package com.bw.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/8/3.
 * 接受者
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver02 {
    @RabbitHandler
    public void process(String message) {
      System.out.println("topicmessage02 object : " + message);
    }

}
