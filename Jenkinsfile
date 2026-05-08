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

        stage('Info System') {
            steps {
                echo "=============================="
                echo "🚀 BUILD INFO"
                echo "Build ID   : ${env.BUILD_ID}"
                echo "Build No   : ${env.BUILD_NUMBER}"
                echo "Workspace  : ${env.WORKSPACE}"
                echo "Node       : ${env.NODE_NAME}"
                echo "Branch     : ${env.BRANCH_NAME}"
                echo "=============================="

                sh '''
                    java -version
                    mvn -version
                '''
            }
        }

        stage('Checkout') {
            steps {
                echo "📥 Checkout source code"
                checkout scm

                sh 'ls -la'
            }
        }

        stage('Clean') {
            steps {
                echo "🧹 Maven clean"
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                echo "⚙️ Compilation"
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Tests unitaires"

                sh 'mvn test'

                sh '''
                    echo "📊 Surefire reports"
                    find target -name "surefire-reports" || true
                    ls -R target/surefire-reports || true
                '''
            }
        }

        stage('Package') {
            steps {
                echo "📦 Packaging"
                sh 'mvn package -DskipTests'

                sh 'ls -lh target/*.jar || true'
            }
        }
    }

    post {

        always {
            echo "=============================="
            echo "📊 FIN BUILD"
            echo "Status: ${currentBuild.currentResult}"
            echo "=============================="

            // 🔥 IMPORTANT : affichage tests dans Jenkins
            junit 'target/surefire-reports/*.xml'

            // sauvegarde logs + rapports
            archiveArtifacts artifacts: 'target/surefire-reports/**', allowEmptyArchive: true
            archiveArtifacts artifacts: '*.log', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }

        success {
            echo "✅ BUILD SUCCESS"
        }

        failure {
            echo "❌ BUILD FAILED"
        }
    }
}
