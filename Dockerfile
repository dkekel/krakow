FROM gradle:7.5-jdk AS builder

WORKDIR /krakow

COPY src /krakow/src
COPY build.gradle /krakow
COPY settings.gradle /krakow

RUN gradle bootJar

FROM eclipse-temurin:17-jre

WORKDIR /app/krakow

COPY --from=builder /krakow/build/libs/*.jar /app/krakow/krakow.jar

EXPOSE 8080

CMD java -jar krakow.jar
