package com.bw.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/8/3.
 * 接受者
 */
@Component
@RabbitListener(queues = "noe")
public class Receiver02 {
    @RabbitHandler
    public void process(String noe) {
        System.out.println("Receiver2  : " + noe);
    }


}
