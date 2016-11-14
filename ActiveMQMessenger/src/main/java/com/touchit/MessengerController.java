package com.touchit;

import com.touchit.JMSProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessengerController {

    @RequestMapping("/sendMsg")
    public @ResponseBody String sendMessage() throws Exception {
        JMSProducer jmsProducer = new JMSProducer();
        jmsProducer.addMessage("Hello world!");
        jmsProducer.start();

        return "Message successfully sent!";
    }
}