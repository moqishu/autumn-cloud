package com.natsucloud.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MessageSender {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send() {
        try {
            String context = "hello " + format.format(new Date());
            System.out.println("Sender : " + context);
            this.rabbitTemplate.convertAndSend("Hello", context);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
