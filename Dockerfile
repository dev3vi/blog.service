# Dockerfile
FROM eclipse-temurin:11.0.13_8-jre-alpine
WORKDIR /app
COPY target/blog_service-0.0.1-SNAPSHOT.jar blog_service.jar
COPY keystore.jks keystore.jks
ENTRYPOINT ["java","-jar","/app/blog_service.jar"]