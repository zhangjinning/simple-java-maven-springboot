FROM openjdk:8

MAINTAINER zjnblank.top

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["nohup", "java", "-jar", "-Duser.timezone=GMT+08", "/app.jar", ">apperr.log", "2>&1&"]
