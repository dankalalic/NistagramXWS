FROM openjdk:8-jdk-alpine
ADD target/settingsservice-0.0.1-SNAPSHOT.jar settingsservice.jar
ENTRYPOINT ["java", "-jar", "./settingsservice.jar"]
EXPOSE 8084