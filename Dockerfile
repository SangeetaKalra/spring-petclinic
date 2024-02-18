# Use an official Maven image as a parent image
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY src /app/src

COPY pom.xml /app

# Build the application
RUN mvn -f /app/pom.xml clean package


# Use the JDK 17 slim image as the base image for the final container
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from the build stage to the new container
COPY --from=build /app/target/*.jar /app/petclinic.jar

# Specify the command to run the application when the container starts
CMD ["java", "-jar", "petclinic.jar"]
