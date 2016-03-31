package com.example.aws.sqs.producer;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AwsSqsProducer {

    @RequestMapping(value = "/sqs", method = RequestMethod.POST)
    public String put() {
        return "Greetings from Spring Boot!";
    }
}



