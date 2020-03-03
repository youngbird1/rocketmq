package com.ct.mq.rocketmq.entity;

import lombok.Data;

/**
 * @Description:
 * @OriginalAuthor:
 * @Author: ChenT
 * @Date: 2020/3/2 23:47
 */
@Data
public class Message {
    private static final long serialVersionUID = 1L;

    private String to;

    private String text;

    public Message(String to ,String text){
        this.to = to;
        this.text = text;
    }
}
