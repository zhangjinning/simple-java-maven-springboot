FROM openjdk:8

MAINTAINER zjnblank.top

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

VOLUME /usr/local/mine/app/apperr.log /apperr.log

#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["nohup", "java", "-jar", "/app.jar", ">/apperr.log", "2>&1&"]
