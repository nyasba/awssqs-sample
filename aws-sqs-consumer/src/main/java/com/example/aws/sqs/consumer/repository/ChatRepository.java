package com.example.aws.sqs.consumer.repository;

import com.example.aws.sqs.consumer.domain.ChatMessage;

public interface ChatRepository {

    void post(ChatMessage chatMessage);

}
