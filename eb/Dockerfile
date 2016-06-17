FROM java:8

# Add sample application
ADD aws-sqs-consumer-1.0.jar aws-sqs-consumer-1.0.jar

EXPOSE 8080

CMD ["java", "-Droomid=<ROOM_ID>", "-Dapitoken=<API_TOKEN>", "-jar", "./aws-sqs-consumer-1.0.jar"]
