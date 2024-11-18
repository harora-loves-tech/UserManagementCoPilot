
pipeline {
    agent any


    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/harora-loves-tech/UserManagementCoPilot.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t docker.io/haroralovestech/user-mgmt-copilot ."
            }
        }

        stage('Docker Push') {
            steps {
                bat "docker push docker.io/haroralovestech/user-mgmt-copilot"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat "kubectl apply -f k8s/deployment.yaml
                bat "kubectl apply -f k8s/ingress.yaml
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build, test, and deployment succeeded!'
        }
        failure {
            echo 'Build, test, or deployment failed.'
        }
    }
}
