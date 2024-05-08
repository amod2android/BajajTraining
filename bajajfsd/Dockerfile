# Use a base image with Java 8 installed
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/bajajfsd.jar /app/bajajfsd.jar

# Expose the port the app runs on
EXPOSE 8081

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "bajajfsd.jar"]