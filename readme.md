## 環境

Windows
Java8

## setup方法

### AWS認証設定を追加

~/.aws/credentials on Linux, OS X or unix  
C:\Users\USERNAME\.aws\credentials on Windows

```
[default]
aws_access_key_id = your_access_key_id
aws_secret_access_key = your_secret_access_key
```

### SQSでキューを作成する

がんばれ。

### Consumerをビルドして、ElasticBeanstalkで起動

```
cd .\aws-sqs-consumer
.\gradlew clean build
cp  .\build\libs\aws-sqs-consumer-1.0.jar ..\eb
```

Dockerfileを編集。  
Chatworkの<ROOM_ID>と<API_TOKEN>をちゃんとしたものに変えて保存

これらをzipにまとめて、ElasticBeanstalkのワーカーとして起動すればOK。


### Producerを起動

キューへ登録する部分を起動

```
cd .\aws-sqs-producer
.\gradlew clean build
java -Dqueuename=<QUEUE_NAME> -jar .\build\libs\aws-sqs-producer-1.0.jar
```

curlなどでAPIを叩くことでキューに登録される

```
curl -X POST localhost:8080/messages -d @test/request.json -H "Content-type: application/json" -i
```


