package com.dongnaoedu.controller;

import com.dongnaoedu.callback.CallBackSender;
import com.dongnaoedu.hello.HelloSender1;
import com.dongnaoedu.topic.TopicSender;
import com.dongnaoedu.user.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/30
 * 创建时间: 10:57
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private UserSender userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private CallBackSender callBackSender;


    /**
     * 单生产者-多消费者
     */
    @GetMapping("/hello")
    public void hello() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
        }

    }

    /**
     * 传输实体类
     */
    @GetMapping("/userTest")
    public void userTest() {
        userSender.send();
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @GetMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * 发送方确认模式
     */
    @GetMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

}
