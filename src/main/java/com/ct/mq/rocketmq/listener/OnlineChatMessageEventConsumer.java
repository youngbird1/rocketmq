package com.ct.mq.rocketmq.listener;

import com.ct.mq.rocketmq.entity.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @OriginalAuthor:
 * @Author: ChenT
 * @Date: 2020/3/2 23:44
 */
@Service
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "OnLineChat")
public class OnlineChatMessageEventConsumer implements RocketMQListener<Message> {

    @Override
    public void onMessage(Message message){
        System.out.println(message.toString());
    }
}
