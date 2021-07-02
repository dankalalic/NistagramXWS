FROM openjdk:8-jdk-alpine
ADD target/CampaignService-0.0.1-SNAPSHOT.jar CampaignService.jar
ENTRYPOINT ["java", "-jar", "./CampaignService.jar"]
EXPOSE 8085