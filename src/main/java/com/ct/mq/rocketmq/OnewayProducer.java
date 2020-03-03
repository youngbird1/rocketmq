package com.ct.mq.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @auther:chent69
 * @date: 2020/1/11-16 :33
 */
public class OnewayProducer {
    public static void main(String[] args) throws Exception{
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("OnLineChat");
        // Specify name server addresses.
        producer.setNamesrvAddr("192.168.1.233:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 30; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("OnLineChat-IP192-168-11" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            producer.sendOneway(msg);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
