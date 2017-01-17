package org.throwable.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangjinci
 * @version 2017/1/17 12:03
 * @function
 */
public class Sender {

    private static final String QUEUE = "HELLO";
    private static final String EXCHANGE = "EXCHANGE";
    private static final String KEY = "key-1";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE, true, false, false, null);
        channel.exchangeDeclare(EXCHANGE, "direct");
        channel.queueBind(QUEUE, EXCHANGE, KEY);
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE, QUEUE, null, message.getBytes());
        channel.close();
        connection.close();
    }
}
