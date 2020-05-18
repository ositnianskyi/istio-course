#!/bin/bash

kubectl apply -f books/deployment/load_balance.yml
kubectl apply -f authors/deployment/load_balance.yml
