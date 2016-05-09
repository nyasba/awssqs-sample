package com.example.aws.sqs.producer.controller;

import com.example.aws.sqs.producer.controller.request.ChatMessageRequest;
import com.example.aws.sqs.producer.domain.ChatMessage;
import com.example.aws.sqs.producer.repository.ChatMessageQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AwsSqsProducerController {

    @Autowired
    private ChatMessageQueueRepository chatMessageQueueRepository;

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public void register(@RequestBody ChatMessageRequest request) {
        ChatMessage chatMessage = request.getChatMessage();
        chatMessageQueueRepository.put(chatMessage);
    }
}



