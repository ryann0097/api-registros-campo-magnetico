# Stage 1: Build do jar
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Imagem final com o jar gerado
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/api-registros-campo-magnetico.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
