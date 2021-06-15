FROM openjdk:8-jdk-alpine
ADD target/followerservice-0.0.1-SNAPSHOT.jar followerservice.jar
ENTRYPOINT ["java", "-jar", "./followerservice.jar"]
EXPOSE 8082