package com.example.aws.sqs.producer.repository;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.aws.sqs.producer.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final String QUEUE_NAME = "test-queue";

    @Override
    public void register(User user) {

        // <UserDirectory>/.aws/credentialsにある認証情報を読み取る
        AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();

        AmazonSQS sqs = new AmazonSQSClient(credentials);
        Region tokyo = Region.getRegion(Regions.AP_NORTHEAST_1);
        sqs.setRegion(tokyo);

        // ターゲットキューのURLを取得
        String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

        //  キューにリクエストを送信
        SendMessageRequest request = new SendMessageRequest(queueUrl, user.getJsonString());
        sqs.sendMessage(request);
    }

}
