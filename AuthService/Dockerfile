FROM openjdk:8-jdk-alpine
ADD target/AuthService-0.0.1-SNAPSHOT.jar AuthService.jar
ENTRYPOINT ["java", "-jar", "./AuthService.jar"]
EXPOSE 8086