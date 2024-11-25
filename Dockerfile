# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build
LABEL authors="bionemac"
LABEL description="This is the Dockerfile for the Users service"

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./

# Make the Maven wrapper executable and download dependencies
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy the source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port (Railway uses port 8080)
EXPOSE 8091

# Define the entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
