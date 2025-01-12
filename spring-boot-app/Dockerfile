# Stage 1: Build the application
FROM gradle:7.6-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and other files
COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

# Copy the application source code
COPY src src

# Grant execution permission for the Gradle wrapper
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew bootJar

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/*.jar /app/spring-boot-app.jar

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/spring-boot-app.jar"]

