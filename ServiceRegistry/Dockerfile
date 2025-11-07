FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY target/Ser-Demo.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
