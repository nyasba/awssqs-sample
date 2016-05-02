package com.example.aws.sqs.producer.controller;

import com.example.aws.sqs.producer.domain.User;
import com.example.aws.sqs.producer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AwsSqsProducerController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void register() {
        User user = new User("きゅーたろう", 15);
        userRepository.register(user);
    }
}



