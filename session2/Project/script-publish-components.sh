#!/bin/bash

docker build -t ositnianskyi/frontend-service:1.0 -f frontend/Dockerfile frontend
docker push ositnianskyi/frontend-service:1.0

docker build -t ositnianskyi/books-service:1.0 -f books/Dockerfile books
docker push ositnianskyi/books-service:1.0

docker build -t ositnianskyi/authors-service:1.0 -f authors/Dockerfile authors
docker push ositnianskyi/authors-service:1.0