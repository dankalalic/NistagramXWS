FROM openjdk:8-jdk-alpine
ADD target/postservice-0.0.1-SNAPSHOT.jar PostService.jar
ENTRYPOINT ["java", "-jar", "./PostService.jar"]
EXPOSE 8083