package com.example.aws.sqs.producer.repository;

import com.example.aws.sqs.producer.domain.ChatMessage;

public interface ChatMessageQueueRepository {

    void put(ChatMessage chatMessage);

}
