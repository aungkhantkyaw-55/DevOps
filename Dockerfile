FROM eclipse-temurin:24-jdk

# Create working directory
WORKDIR /app

# Copy only the fat jar produced by maven
COPY ./target/alpha-0.1.0.2-jar-with-dependencies.jar app.jar

# Default entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]

