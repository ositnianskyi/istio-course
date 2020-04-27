# HW: Sesion 2

Build and push applications: `script-build-components.sh` and `script-publish-components.sh`
DockerHub account https://hub.docker.com/u/ositnianskyi

![Alt text](resources/docker_hub.png?raw=true)

Deploy to local k8s: `script-deploy-components.sh` and `script-configure-routing.sh`
![Alt text](resources/k9s.png?raw=true)

Check frontend app response: get address `kubectl-get-public-ip.sh`
http://localhost/frontend-catalog/api/v1/dashboard

![Alt text](resources/frontend_response.png?raw=true)

Kiali: `istioctl dashboard kiali`
![Alt text](resources/kiali_graph.png?raw=true)

![Alt text](resources/kiali_apps.png?raw=true)

![Alt text](resources/kiali_metrics.png?raw=true)

Grafana: `istioctl dashboard grafana`
![Alt text](resources/grafana_authors.png?raw=true)

![Alt text](resources/grafana_books.png?raw=true)

![Alt text](resources/grafana_frontend.png?raw=true)

Jager: `istioctl dashboard jaeger`
![Alt text](resources/jager.png?raw=true)
