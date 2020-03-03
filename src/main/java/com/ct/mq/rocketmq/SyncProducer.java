package com.ct.mq.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @auther:chent69
 * @date: 2020/1/11-16 :26
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        System.out.println("################## test rocketMQ 1111111 #######################");
        DefaultMQProducer producer = new
                DefaultMQProducer("syncProducer");
        // Specify name server addresses.
        producer.setNamesrvAddr("10.206.148.44:9876");
        producer.setVipChannelEnabled(true);
        producer.setSendMsgTimeout(50000);
        //Launch the instance.
        producer.start();
        System.out.println("################## test rocketMQ 22222222 #######################");
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        System.out.println("################## test rocketMQ 33333333 #######################");
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
