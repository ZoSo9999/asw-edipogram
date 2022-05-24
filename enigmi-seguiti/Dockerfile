# Dockerfile per il servizio enigmi-seguiti
FROM openjdk:11-jdk
RUN apt-get update && apt-get install -y curl
ADD build/libs/enigmi-seguiti.jar enigmi-seguiti.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "enigmi-seguiti.jar"]