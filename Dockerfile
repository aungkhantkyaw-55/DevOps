FROM openjdk:24

# Copy compiled classes
COPY ./target/classes /app/classes

# Download MySQL connector directly
ADD https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar /app/mysql-connector-java.jar

WORKDIR /app

# Run with classpath including the driver
CMD ["java", "-cp", "classes:/app/mysql-connector-java.jar", "com.napier.devops.App"]

