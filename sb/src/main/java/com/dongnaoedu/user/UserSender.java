package com.dongnaoedu.user;

import java.util.Date;

import com.dongnaoedu.RmConst;
import com.dongnaoedu.SpringbootRmApplication;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/30
 * 创建时间: 11:02
 */

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("Mark");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend(RmConst.QUEUE_USER, user);
        System.out.println("*****");
    }

}
