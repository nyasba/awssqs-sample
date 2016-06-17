package com.example.aws.sqs.consumer.controller;

import com.example.aws.sqs.consumer.controller.request.ChatMessageRequest;
import com.example.aws.sqs.consumer.domain.ChatMessage;
import com.example.aws.sqs.consumer.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AwsSqsConsumerController {

    @Autowired
    private ChatRepository chatRepository;

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public void consume(@RequestBody ChatMessageRequest request) {
        ChatMessage chatMessage = request.getChatMessage();
        chatRepository.post(chatMessage);
    }
}



