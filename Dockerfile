FROM openjdk:8-jdk-alpine

MAINTAINER aning/663232104@qq.com

WORKDIR app

COPY demo-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java -jar app.jar"]
