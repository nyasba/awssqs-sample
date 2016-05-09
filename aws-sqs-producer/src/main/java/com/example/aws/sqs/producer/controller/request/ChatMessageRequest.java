package com.example.aws.sqs.producer.controller.request;

import com.example.aws.sqs.producer.domain.ChatMessage;

public class ChatMessageRequest {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatMessage getChatMessage(){
        return new ChatMessage(this.message);
    }
}
