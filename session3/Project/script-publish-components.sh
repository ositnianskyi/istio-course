#!/bin/bash

docker build -t ositnianskyi/frontend-service:2.0 -f frontend/Dockerfile frontend
docker push ositnianskyi/frontend-service:2.0

docker build -t ositnianskyi/books-service:2.0 -f books/Dockerfile books
docker push ositnianskyi/books-service:2.0

docker build -t ositnianskyi/authors-service:2.0 -f authors/Dockerfile authors
docker push ositnianskyi/authors-service:2.0