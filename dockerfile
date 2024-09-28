FROM maven:3.8.4-openjdk-11 AS builder
WORKDIR /app
COPY . .
RUN mvn clean install

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/target/yourapp.jar /app/yourapp.jar
ENTRYPOINT ["java", "-jar", "/app/yourapp.jar"]
