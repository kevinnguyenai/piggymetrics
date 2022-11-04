FROM java:8-jre
MAINTAINER Kevin Nguyen <kevin.nguyen.ai@gmail.com>

ADD ./target/zipkin.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/zipkin.jar"]

EXPOSE 9411