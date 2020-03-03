package com.ct.mq.rocketmq.service;

import com.ct.mq.rocketmq.entity.Message;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @OriginalAuthor:
 * @Author: ChenT
 * @Date: 2020/3/2 23:53
 */
@Service
public class RocketMqSendMessageClient {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //send spring message
    public void sendMsg(String topic , String str){
        rocketMQTemplate.send(topic, MessageBuilder.withPayload(new Message("10010",str)).build());
    }

    //send message synchronously
    public void synchronouslySend(String topic, String message){
        rocketMQTemplate.convertAndSend(topic, message);
    }

    //send messgae asynchronously
    public void asyncSend(String topic, String message){
        rocketMQTemplate.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) {
                System.out.printf("async onSucess SendResult=%s %n", var1);
            }

            @Override
            public void onException(Throwable var1) {
                System.out.printf("async onException Throwable=%s %n", var1);
            }

        });
    }
}
