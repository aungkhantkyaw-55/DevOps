FROM openjdk:24
WORKDIR /tmp
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
