FROM maven:3.8.3-openjdk-17 AS builder
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml .
RUN mvn -v
RUN mvn -e -B -DskipTests dependency:resolve
COPY src ./src
RUN mvn -e -B -DskipTests package

FROM openjdk:17
COPY --from=builder /app/target/spring-test-performance-db-async-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 6002 8080
ENTRYPOINT exec java $JAVA_JMX_REMOTE $JAVA_OPTS $TIME_ZONE -jar /app/app.jar $JAVA_CONFIG