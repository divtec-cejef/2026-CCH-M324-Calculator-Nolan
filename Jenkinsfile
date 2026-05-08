pipeline {
    agent any

    tools {
        maven 'Maven 3.9'
        jdk 'OpenJDK 21.0.10'
    }

    options {
        timestamps()        // 🕒 horodatage logs
        ansiColor('xterm')  // 🎨 logs lisibles
        buildDiscarder(logRotator(numToKeepStr: '10'))
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
                    echo "📌 Java version"
                    java -version

                    echo "📌 Maven version"
                    mvn -version

                    echo "📌 Environment"
                    env | sort
                '''
            }
        }

        stage('Checkout') {
            steps {
                echo "📥 Checkout source code"
                checkout scm

                sh '''
                    echo "📂 Listing repository files"
                    ls -la
                '''
            }
        }

        stage('Clean') {
            steps {
                echo "🧹 Maven clean start (debug mode)"
                sh 'mvn clean -X -e | tee clean.log'
            }
        }

        stage('Compile') {
            steps {
                echo "⚙️ Compilation du projet"
                sh 'mvn compile -X -e | tee compile.log'
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Lancement des tests unitaires"

                sh '''
                    mvn test -X -e | tee test.log
                    echo "📊 Résultats tests"
                    find target -name "surefire-reports" -type d || true
                '''
            }
        }

        stage('Package') {
            steps {
                echo "📦 Packaging application (skip tests)"
                sh 'mvn package -DskipTests -X -e | tee package.log'

                sh '''
                    echo "📦 JAR généré :"
                    ls -lh target/*.jar || true
                '''
            }
        }
    }

    post {

        always {
            echo "=============================="
            echo "📊 FIN BUILD"
            echo "Status: ${currentBuild.currentResult}"
            echo "=============================="

            archiveArtifacts artifacts: '*.log', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true

            sh '''
                echo "📂 Final workspace state"
                ls -R | head -200
            '''
        }

        success {
            echo "✅ BUILD SUCCESS"
        }

        failure {
            echo "❌ BUILD FAILED - check logs"
        }
    }
}
