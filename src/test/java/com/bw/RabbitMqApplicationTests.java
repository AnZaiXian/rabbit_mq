package com.bw;

import com.bw.entity.User;
import com.bw.sender.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTests {

	//hello
	@Autowired
	private HelloSender helloSender;

	//一对多
	@Autowired
	private NeoSender neoSender;

	//多对多
	@Autowired
	private NeoSender02 neoSender02;

	//对象实例
	@Autowired
	private ObjectSender objectSender;

	//队列实例
	@Autowired
	private TopicSender01 topicSender01;

	//创建将发送的消息绑定在交换机上的实例
	@Autowired
	private FanoutSender fanoutSender;

	@Test
	public void hello() throws Exception {
		helloSender.send();
	}

	//一对多
	@Test
	public void oneToMany() throws Exception {
       for (int i=0;i<100;i++){
         neoSender.send(i);
       }
	}

	//多对多
	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			neoSender.send(i);
			neoSender02.send(i);
		}
	}

	//传输对象
	@Test
	public void sentobject() throws Exception {
		User user = new User(2,"张三");
		objectSender.send(user);
	}


	//将信息绑定到交换机上获取topicSender01
	//发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息
	// ，发送send2只有topic.#可以匹配所有只有Receiver2监听到消息
	@Test
	public void topicmessage() throws Exception {

		  topicSender01.send1();
		//topicSender01.send2();
	}


	/**
	 * 给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息
	 */
	@Test
	public void fanoutExchange() throws Exception {

		fanoutSender.send();
	}


	@Test
	public void contextLoads() {
	}

}
