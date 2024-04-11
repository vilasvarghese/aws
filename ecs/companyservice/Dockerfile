FROM ubuntu:latest
RUN apt-get -y update && apt-get -y install openjdk-8-jdk wget && mkdir /usr/local/tomcat && wget https://downloads.apache.org/tomcat/tomcat-8/v8.5.88/bin/apache-tomcat-8.5.88.tar.gz -O /tmp/tomcat.tar.gz &&  cd /tmp && tar xvfz tomcat.tar.gz && cp -Rv /tmp/apache-tomcat-8.5.88/* /usr/local/tomcat/
COPY target/companyservice-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/
EXPOSE 8080
CMD /usr/local/tomcat/bin/catalina.sh run