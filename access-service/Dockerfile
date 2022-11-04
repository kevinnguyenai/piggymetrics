FROM java:8-jre
MAINTAINER MAINTAINER Kevin Nguyen <kevin.nguyen.ai@gmail.com>

ADD ./target/access-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/access-service.jar"]

EXPOSE 7000