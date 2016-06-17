package com.example.aws.sqs.consumer.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatMessage {

    private final String body;

    public ChatMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss"));
        return String.format("[P %s]%s\" } ", now, body);
    }
}
