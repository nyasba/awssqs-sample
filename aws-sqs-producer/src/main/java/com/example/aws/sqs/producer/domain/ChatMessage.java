package com.example.aws.sqs.producer.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatMessage {

    private final String message;

    public ChatMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getJsonString() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss"));
        return String.format("{ \"message\" : \"[%s]%s\" } ", now, message);
    }
}
