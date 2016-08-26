FROM openjdk:8-alpine
RUN mkdir /var/simplicite
ADD app /var/simplicite/app
COPY target/tomcat-0.0.1-SNAPSHOT-jar-with-dependencies.jar /var/simplicite/tomcat.jar
WORKDIR /var/simplicite
CMD ["java", "-jar", "tomcat.jar"]
