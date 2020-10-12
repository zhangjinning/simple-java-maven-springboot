FROM openjdk:8

MAINTAINER zjnblank.top

ADD target/demo-0.0.1-SNAPSHOT.jar app.jar

ADD start.sh start.sh

EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "/app.jar"]
#CMD ["nohup", "java", "-jar", "-Duser.timezone=GMT+08", "/app.jar", ">", "/apperr.log", "2>&1&"]
ENTRYPOINT ["nohup", "sh", "start.sh"]
