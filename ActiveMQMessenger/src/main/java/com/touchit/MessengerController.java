package com.touchit;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MessengerController {
    @RequestMapping(value = "/sendMessage.htm")
    public void sendMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = "localhost:61616";
        JMSProducer jmsProducer = new JMSProducer(url);
        jmsProducer.addMessage("Hello world!");
        jmsProducer.start();
    }
}