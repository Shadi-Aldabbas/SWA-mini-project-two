FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]
EXPOSE 9002