#!/bin/bash

#kubectl delete all -lproject=istio-course -n default

#kubectl apply -f frontend/deployment/deployment.yml
kubectl apply -f books/deployment/deployment.yml
#kubectl apply -f authors/deployment/deployment.yml