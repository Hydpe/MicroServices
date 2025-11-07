FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY target/Auth-Demo.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
