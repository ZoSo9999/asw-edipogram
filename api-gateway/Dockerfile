# Dockerfile per il servizio api-gateway
FROM openjdk:11-jdk
RUN apt-get update && apt-get install -y curl
ADD build/libs/api-gateway.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "api-gateway.jar"]
