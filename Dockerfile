FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY ./target/devops.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "db:3306", "30000"]
