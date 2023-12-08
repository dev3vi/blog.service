#!/bin/bash

git pull origin master
mvn clean install
docker stop blog.service
docker rm blog.service
docker rmi blog-image
docker build -t blog-image .
docker run -p 8081:8081 -d --name blog.service blog-image

#Remove unused data
#docker system prune

chmod +x deploy.sh
