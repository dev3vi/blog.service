#!/bin/bash

git pull origin master
mvn clean install
docker stop blog.service
docker rm blog.service
docker build -t blog-image .
docker run -p 8081:8081 blog-image

chmod +x deploy.sh
