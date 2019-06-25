#!/usr/bin/env bash
docker run -p 8282:8080 -p 50000:50000 -v /home/inigo/Dropbox/jenkins:/var/jenkins_home jenkins &