pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'OpenJDK 21.0.10'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

    }

    post {
        success {
            echo "✅ Build Maven réussi"
        }

        failure {
            echo "❌ Build échoué"
        }
    }
}
