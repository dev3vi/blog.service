# Dockerfile
FROM openjdk:11-jdk-alpine
COPY target/blog_service-0.0.1-SNAPSHOT.jar blog_service.jar
ENTRYPOINT ["java","-jar","/blog_service.jar"]
WORKDIR /app
EXPOSE 8081