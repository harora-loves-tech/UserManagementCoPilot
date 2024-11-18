
pipeline {
    agent any

 
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'checkout'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                bat 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                // Build Docker image
                bat 'docker build -t usermanagementcopilot . -t haroralovestech/usermanagementcopilot'
            }
        }

        stage('Docker Push') {
            steps {
                // Push Docker image to registry
                bat 'docker login -u haroralovestech -p $DOCKER_PASSWORD'
                bat 'docker push docker.io/haroralovestech/usermanagementcopilot/usermanagementcopilot'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy the application
                bat 'kubectl apply -f deployment.yaml'
                bat 'kubectl apply -f ingress.yaml'
            }
    }

    post {
        always {
            // Archive the build artifacts
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        success {
            // Notify success
            echo 'Build and tests succeeded!'
        }
        failure {
            // Notify failure
            echo 'Build or tests failed.'
        }
    }
}
