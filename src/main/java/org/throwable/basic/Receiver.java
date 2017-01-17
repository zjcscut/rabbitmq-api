package org.throwable.basic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zhangjinci
 * @version 2017/1/17 12:11
 * @function
 */
public class Receiver {

    public static final String QUEUE = "HELLO";

    public static int concurrentCustomerNum = 10;

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();

        for (int i = 0; i < concurrentCustomerNum; i++) {
            Channel channel = ChannelFactory.bornRabbitmqChannel(connection);
            channel.queueDeclare(QUEUE, true, false, false, null);
            channel.basicQos(1);
            new ConcreateConsumer(channel).run();
        }


        System.in.read();
    }
}
