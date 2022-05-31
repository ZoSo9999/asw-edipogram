# Dockerfile per il servizio connessioni
FROM openjdk:17-jdk
#RUN apt-get update && apt-get install -y curl
ADD build/libs/connessioni.jar connessioni.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "connessioni.jar"]
