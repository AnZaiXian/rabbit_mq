package com.bw.configuration;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by lenovo on 2017/8/3.
 * Fanout 就是我们熟悉的广播模式或者订阅模式，
 * 给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息
 * Broker：简单来说就是消息队列服务器实体。
 * Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列。
 * Queue：消息队列载体，每个消息都会被投入到一个或多个队列。
 * Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来。
 * Routing Key：路由关键字，exchange根据这个关键字进行消息投递。
 * vhost：虚拟主机，一个broker里可以开设多个vhost，用作不同用户的权限分离。
 * producer：消息生产者，就是投递消息的程序。
 * consumer：消息消费者，就是接受消息的程序。
 * channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务。
 *
 */

@Configuration
public class FanoutRabbitConfig {

//Queue  消息队列载体，每个消息都会被投入到一个或多个队列。
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

//fanoutExchange   Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列。
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

//Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来。
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
