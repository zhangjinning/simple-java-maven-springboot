FROM openjdk:8-jdk-alpine

MAINTAINER aning/663232104@qq.com

VOLUME ["/tmp"]

EXPOSE 8080

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", " -jar", " app.jar"]
