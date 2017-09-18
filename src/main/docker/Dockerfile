FROM java:8

MAINTAINER Carl J. Mosca <carljmosca@gmail.com>

VOLUME /tmp

ADD rest-demo-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_CACERTS /etc/ssl/certs/java/cacerts

ADD certs/tomcat.secure.crt /etc/ssl/certs
ADD keystore.jks /etc/ssl/certs/java/keystore.jks

RUN keytool -noprompt -storepass changeit -keystore ${JAVA_CACERTS} -import -file /etc/ssl/certs/tomcat.secure.crt -alias tomcat

ENV SERVER_SSL_KEY-STORE=/etc/ssl/certs/java/keystore.jks

CMD java $JAVA_OPTIONS -Djava.security.egd=file:/dev/./urandom -jar /app.jar

USER 185
