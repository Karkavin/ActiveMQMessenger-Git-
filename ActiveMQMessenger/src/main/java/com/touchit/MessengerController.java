package com.touchit;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessengerController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping("/send")
    public String helloW() {
        return "Please, enter correct: ~/send/{message}";
    }

    @RequestMapping("/send/{message}")
    public @ResponseBody String send(@PathVariable String message) throws Exception {
        JMSProducer jmsProducer = new JMSProducer();
        jmsProducer.addMessage(message);
        jmsProducer.start();

        return "Message " + message + " successfully sent!";
    }
}