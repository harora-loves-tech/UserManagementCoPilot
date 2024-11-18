## Prerequisites

- Java 17
- Maven 3.6+
- Docker
- Kubernetes cluster (Docker Desktop)

## Getting Started

### Clone the Repository
git clone https://github.com/UserManagementCoPilot.git 
cd UserManagementCoPilot

### Build the Application
mvn clean install

### Run Tests
mvn test

### Package the Application
mvn package

## Docker
### Build Docker Image
docker build -t usermanagementcopilot .


### Run Docker Container
docker run -p 8081:8081 usermanagementcopilot

## Kubernetes
### Deploy to Kubernetes
### Ensure you have the following Kubernetes deployment files in the project root directory:
#### `deployment.yaml`
#### `k8s/ingress.yaml`


### Apply Kubernetes Configurations

kubectl apply -f deployment.yaml 
kubectl apply -f ingress.yaml
