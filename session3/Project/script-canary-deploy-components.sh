#!/bin/bash

kubectl apply -f books/deployment/canary_deployment_0_100.yml
kubectl apply -f authors/deployment/canary_deployment_0_100.yml