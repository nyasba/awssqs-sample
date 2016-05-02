package com.example.aws.sqs.producer.repository;

import com.example.aws.sqs.producer.domain.User;

public interface UserRepository {

    void register(User user);

}
