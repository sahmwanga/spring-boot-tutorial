FROM openjdk:17-jdk-slim as builder
WORKDIR application
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTests

FROM openjdk:17-alpine
#FROM openjdk:17-jre-slim
WORKDIR application
COPY --from=builder application/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]