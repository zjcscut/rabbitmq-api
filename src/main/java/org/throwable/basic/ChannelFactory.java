package org.throwable.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author zhangjinci
 * @version 2017/1/17 17:55
 * @function
 */
public class ChannelFactory {

    public static Channel bornRabbitmqChannel(Connection connection){
        try {
            return connection.createChannel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
