FROM openjdk:8

MAINTAINER zjnblank.top

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
