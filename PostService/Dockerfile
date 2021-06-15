FROM openjdk:8-jdk-alpine
ADD target/PostService-0.0.1-SNAPSHOT.jar PostService.jar
ENTRYPOINT ["java", "-jar", "./PostService.jar"]
EXPOSE 8083