package com.example.aws.sqs.consumer.domain;

public class ChatMessage {

    private final String body;

    public ChatMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        String user = System.getProperty("user.name", "unknown");
        return "[" + user + "] " + body;
    }
}
