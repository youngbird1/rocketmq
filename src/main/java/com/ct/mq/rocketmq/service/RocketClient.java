package com.ct.mq.rocketmq.service;

import com.ct.mq.rocketmq.entity.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @OriginalAuthor:
 * @Author: ChenT
 * @Date: 2020/3/2 23:53
 */
@Service
public class RocketClient {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMsg(String str){
        rocketMQTemplate.send("TestTopic", MessageBuilder.withPayload(new Message("10010",str)).build());
    }
}
