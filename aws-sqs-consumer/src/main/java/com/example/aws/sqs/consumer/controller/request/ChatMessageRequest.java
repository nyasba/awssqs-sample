package com.example.aws.sqs.consumer.controller.request;


import com.example.aws.sqs.consumer.domain.ChatMessage;

import java.io.Serializable;

public class ChatMessageRequest implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatMessage getChatMessage(){
        return new ChatMessage(message);
    }
}
