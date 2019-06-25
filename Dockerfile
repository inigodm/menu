FROM jenkins/jenkins

USER root

RUN apt-get -y update && apt-get -y upgrade && apt-get -y install maven gradle vim openjdk-8-jdk

USER jenkins

#docker build . -t jenkins