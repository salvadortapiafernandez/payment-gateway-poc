FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y maven
RUN mvn clean package
EXPOSE 8080
CMD ["java", "-jar", "target/payments-service-0.0.1-SNAPSHOT.jar"]