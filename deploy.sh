#!/bin/bash

git pull origin master
mvn clean install
docker stop blog.service
docker rm blog.service
docker build -t blog .
docker run -p 8081:8081 blog.service

chmod +x deploy.sh
