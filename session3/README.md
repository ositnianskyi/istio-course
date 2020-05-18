# HW: Sesion 3

Build and push applications v2: `script-build-components.sh` and `script-publish-components.sh`

#Canary deployment
Run script: `script-canary-deploy-components.sh`

- Route 10% of incoming request to the v2 and 90% to v1
[Configurationauthors](Project/authors/deployment/canary_deployment_10_90.yml)
[Configuration books](Project/books/deployment/canary_deployment_10_90.yml)
![Alt text](resources/Canary_deployment_10_90.png?raw=true)

- Route 50% of incoming request to the v2 and 50% to v1
[Configuration authors](Project/authors/deployment/canary_deployment_50_50.yml)
[Configuration books](Project/books/deployment/canary_deployment_50_50.yml)
![Alt text](resources/Canary_deployment_50_50.png?raw=true)

- Route 100% of incoming request to the v2 and 0% to v1
[Configuration authors](Project/authors/deployment/canary_deployment_0_100.yml)
[Configuration books](Project/books/deployment/canary_deployment_0_100.yml)
![Alt text](resources/Canary_deployment_0_100.png?raw=true)

#Development environment
Run script: `script-dev-env-deploy-components.sh`

[Configuration frontend (course-istio service)](Project/gateway/dev_env.yml)

Request: `http://localhost/frontend-catalog/api/v1/dashboard` with headers: `developer=os`
![Alt text](resources/Development_environment.png?raw=true)

#Service resiliency
Run script: `script-load-balance-deploy-components.sh`

[Configuration authors](Project/authors/deployment/load_balance.yml)
[Configuration books](Project/books/deployment/load_balance.yml)

![Alt text](resources/Service_resiliency.png?raw=true)

Load tests via fortio:
```odl1811006:istio-1.5.1 ositnianskyi$ kubectl exec -it $FORTIO_POD  -c fortio /usr/bin/fortio -- load -c 3 -qps 0 -n 30 -loglevel Warning http://books:8080/api/v1/books
   18:40:41 I logger.go:97> Log level is now 3 Warning (was 2 Info)
   Fortio 1.3.1 running at 0 queries per second, 4->4 procs, for 30 calls: http://books:8080/api/v1/books
   Starting at max qps with 3 thread(s) [gomax 4] for exactly 30 calls (10 per thread + 0)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:40:41 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   Ended after 212.0994ms : 30 calls. qps=141.44
   Aggregated Function Time : count 30 avg 0.015272783 +/- 0.01367 min 0.000808 max 0.0568868 sum 0.4581835
   # range, mid point, percentile, count
   >= 0.000808 <= 0.001 , 0.000904 , 3.33, 1
   > 0.001 <= 0.002 , 0.0015 , 10.00, 2
   > 0.002 <= 0.003 , 0.0025 , 23.33, 4
   > 0.003 <= 0.004 , 0.0035 , 30.00, 2
   > 0.004 <= 0.005 , 0.0045 , 36.67, 2
   > 0.007 <= 0.008 , 0.0075 , 40.00, 1
   > 0.008 <= 0.009 , 0.0085 , 43.33, 1
   > 0.01 <= 0.011 , 0.0105 , 46.67, 1
   > 0.012 <= 0.014 , 0.013 , 53.33, 2
   > 0.014 <= 0.016 , 0.015 , 56.67, 1
   > 0.016 <= 0.018 , 0.017 , 63.33, 2
   > 0.018 <= 0.02 , 0.019 , 70.00, 2
   > 0.02 <= 0.025 , 0.0225 , 83.33, 4
   > 0.025 <= 0.03 , 0.0275 , 86.67, 1
   > 0.03 <= 0.035 , 0.0325 , 90.00, 1
   > 0.04 <= 0.045 , 0.0425 , 96.67, 2
   > 0.05 <= 0.0568868 , 0.0534434 , 100.00, 1
   # target 50% 0.013
   # target 75% 0.021875
   # target 90% 0.035
   # target 99% 0.0548208
   # target 99.9% 0.0566802
   Sockets used: 14 (for perfect keepalive, would be 3)
   Code 200 : 18 (60.0 %)
   Code 503 : 12 (40.0 %)
   Response Header Sizes : count 30 avg 107.83333 +/- 88.05 min 0 max 180 sum 3235
   Response Body/Total Sizes : count 30 avg 454.96667 +/- 188.9 min 241 max 681 sum 13649
   All done 30 calls (plus 0 warmup) 15.273 ms avg, 141.4 qps 
```
```   
   odl1811006:istio-1.5.1 ositnianskyi$ kubectl exec -it $FORTIO_POD  -c fortio /usr/bin/fortio -- load -c 3 -qps 0 -n 30 -loglevel Warning http://authors:8080/api/v1/authors
   18:44:18 I logger.go:97> Log level is now 3 Warning (was 2 Info)
   Fortio 1.3.1 running at 0 queries per second, 4->4 procs, for 30 calls: http://authors:8080/api/v1/authors
   Starting at max qps with 3 thread(s) [gomax 4] for exactly 30 calls (10 per thread + 0)
   18:44:18 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   18:44:18 W http_client.go:679> Parsed non ok code 503 (HTTP/1.1 503)
   Ended after 148.6169ms : 30 calls. qps=201.86
   Aggregated Function Time : count 30 avg 0.01372673 +/- 0.006462 min 0.0008331 max 0.0290681 sum 0.4118019
   # range, mid point, percentile, count
   >= 0.0008331 <= 0.001 , 0.00091655 , 3.33, 1
   > 0.006 <= 0.007 , 0.0065 , 6.67, 1
   > 0.007 <= 0.008 , 0.0075 , 16.67, 3
   > 0.008 <= 0.009 , 0.0085 , 26.67, 3
   > 0.009 <= 0.01 , 0.0095 , 36.67, 3
   > 0.01 <= 0.011 , 0.0105 , 43.33, 2
   > 0.011 <= 0.012 , 0.0115 , 50.00, 2
   > 0.012 <= 0.014 , 0.013 , 56.67, 2
   > 0.014 <= 0.016 , 0.015 , 66.67, 3
   > 0.016 <= 0.018 , 0.017 , 73.33, 2
   > 0.018 <= 0.02 , 0.019 , 80.00, 2
   > 0.02 <= 0.025 , 0.0225 , 93.33, 4
   > 0.025 <= 0.0290681 , 0.0270341 , 100.00, 2
   # target 50% 0.012
   # target 75% 0.0185
   # target 90% 0.02375
   # target 99% 0.0284579
   # target 99.9% 0.0290071
   Sockets used: 5 (for perfect keepalive, would be 3)
   Code 200 : 28 (93.3 %)
   Code 503 : 2 (6.7 %)
   Response Header Sizes : count 30 avg 167.46667 +/- 44.76 min 0 max 180 sum 5024
   Response Body/Total Sizes : count 30 avg 408.4 +/- 75.96 min 241 max 472 sum 12252
   All done 30 calls (plus 0 warmup) 13.727 ms avg, 201.9 qps
```


