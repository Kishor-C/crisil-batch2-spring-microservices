FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app-server.jar
ENTRYPOINT ["java", "-jar", "/app-server.jar"]