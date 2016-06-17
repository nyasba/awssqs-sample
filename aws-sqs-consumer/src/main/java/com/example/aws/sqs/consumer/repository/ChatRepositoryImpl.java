package com.example.aws.sqs.consumer.repository;

import com.example.aws.sqs.consumer.domain.ChatMessage;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class ChatRepositoryImpl implements ChatRepository {

    private static final String ENDPOINT_URL = "https://api.chatwork.com/v1/rooms/__ROOM_ID__/messages";

    @Override
    public void post(ChatMessage chatMessage) {

        RestTemplate restTemplate = new RestTemplate();

        String url = ENDPOINT_URL.replace("__ROOM_ID__", System.getProperty("roomid"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-ChatWorkToken", System.getProperty("apitoken") );

        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("body", chatMessage.getBody());

        HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

}
