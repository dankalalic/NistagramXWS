FROM openjdk:8-jdk-alpine
ADD target/messagesservice-0.0.1-SNAPSHOT.jar messagesservice.jar
ENTRYPOINT ["java", "-jar", "./messagesservice.jar"]
EXPOSE 8091