package com.ct.mq.rocketmq.controller;

import com.ct.mq.rocketmq.service.RocketMqSendMessageClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @OriginalAuthor:
 * @Author: ChenT
 * @Date: 2020/3/2 23:58
 */
@RestController
@RequestMapping("test")
public class testController {
    @Resource
    RocketMqSendMessageClient rocketClient;

    @PostMapping
    public String rocketMqSendMsg(@RequestParam String str){
        rocketClient.sendMsg("TopicTest",str);
        return str;
    }
}
