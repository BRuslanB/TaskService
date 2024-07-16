FROM openjdk:17-slim
MAINTAINER ruslan
WORKDIR /app
COPY ./build/libs/*.jar app-task-service.jar
ENTRYPOINT ["java", "-jar", "app-task-service.jar"]