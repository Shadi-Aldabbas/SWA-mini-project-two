FROM openjdk:15-jdk-alpine
LABEL maintainer="aabdeen@miu.edu"

VOLUME /main-app
ADD /target/spring-batch-example-1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]