package com.bw.receiver;

import com.bw.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/8/3.
 * 接受者
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver01 {
    @RabbitHandler
    public void process(String message) {
      System.out.println("topicmessage01 object : " + message);
    }

}
