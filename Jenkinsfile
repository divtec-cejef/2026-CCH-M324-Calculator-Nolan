pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'OpenJDK 21.0.10'
    }

    environment {
        MAVEN_OPTS = "-Xms256m -Xmx1024m"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
                sh 'ls -la'
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
                echo "🧪 Running tests"
                sh 'mvn test'
            }
        }

        stage('Coverage') {
            steps {
                jacoco execPattern: 'target/jacoco.exec'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                sh 'ls -lh target/*.jar || true'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/**/*.jar', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/site/jacoco/**', allowEmptyArchive: true
        }

        success {
            echo "✅ BUILD SUCCESS"
        }

        failure {
            echo "❌ BUILD FAILED"
        }
    }
}
