#!/bin/bash

kubectl apply -f books/deployment/fault_injection.yml
kubectl apply -f authors/deployment/fault_injection.yml
