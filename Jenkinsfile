pipeline {
    agent { docker { image 'node:16.13.1-alpine' } }
    stages {
        stage('build') {
            steps {
                echo "building the application.."
                sh 'node --version'
            }
        }
        stage('test') {
            steps {
                echo "testing the application..."
                sh 'node --version'
            }
        }
    }
}