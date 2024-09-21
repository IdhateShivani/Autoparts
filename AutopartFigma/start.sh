#!/bin/bash
# Navigate to the project directory
cd /c/Users/MAHADEV/git/Autoparts/AutopartFigma

# Build the project
./mvnw clean package

# Start the Spring Boot application
java -jar target/myfile.jar

