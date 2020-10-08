FROM openjdk:8-jdk-alpine

MAINTAINER aning/663232104@qq.com

VOLUME ["/tmp"]

EXPOSE 8080

CMD ["ls -a"]

COPY app.jar app.jar

ENTRYPOINT ["java -jar app.jar"]