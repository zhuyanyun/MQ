package com.dongnaoedu.hello;

import com.dongnaoedu.RmConst;
import com.dongnaoedu.SpringbootRmApplication;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/30
 * 创建时间: 10:56
 */
@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        String sendMsg = msg +"---"+ System.currentTimeMillis();;
        System.out.println("Sender : " + sendMsg);
        this.rabbitTemplate.convertAndSend(RmConst.QUEUE_HELLO, sendMsg);
    }

}
