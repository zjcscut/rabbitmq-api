package org.throwable.basic;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author zhangjinci
 * @version 2017/1/17 17:32
 * @function
 */
public class ConcreateConsumer implements Consumer,Runnable {

    private Channel channel;

    public ConcreateConsumer(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void handleConsumeOk(String consumerTag) {

    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
            String message = new String(body,"UTF-8");
        System.out.println("consumerTag :" + consumerTag);
        System.out.println("envelope - Exchange :" + envelope.getExchange());
        System.out.println("envelope - RoutingKey :" + envelope.getRoutingKey());
        System.out.println("envelope - DeliveryTag :" + envelope.getDeliveryTag());
        System.out.println("body - string :" + message);
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void consume()throws IOException{
        channel.basicConsume(Receiver.QUEUE,true,this);
    }
}
