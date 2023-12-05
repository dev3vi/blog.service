# Dockerfile
FROM openjdk:11-jdk-alpine
COPY target/spring-boot-app.jar spring-boot-app.jar
ENTRYPOINT ["java","-jar","/spring-boot-app.jar"]
WORKDIR /app
EXPOSE 8081