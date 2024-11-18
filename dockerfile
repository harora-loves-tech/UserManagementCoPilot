# Use an official OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file
COPY target/UserManagementCoPilot-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]