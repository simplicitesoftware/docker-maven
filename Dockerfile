FROM openjdk:8-alpine
RUN mkdir /var/simplicite
ADD webapps /var/simplicite/webapps
COPY target/tomcat-0.0.1-SNAPSHOT-jar-with-dependencies.jar /var/simplicite
WORKDIR /var/simplicite
CMD ["java", "-jar", "tomcat-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]
