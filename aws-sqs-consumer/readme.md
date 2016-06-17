
## consumerのみ個別にテストする方法

### Spring Bootの起動

```
gradlew clean build
java -Droomid=<ROOMID> -Dapitoken=<APITOKEN> -jar build\libs\aws-sqs-consumer-1.0.jar
```

### API直叩きのテスト

```
curl -X POST http://localhost:8080/messages -H "Content-type: application/json" -d "{ \"message\":\"message sample\" }"
```