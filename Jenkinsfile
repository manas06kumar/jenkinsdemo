pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/manas06kumar/jenkinsdemo.git'
            }
        }
        stage('Build App') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t jenkinsdemo:latest .'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name jenkinsdemo -p 8081:8500 jenkinsdemo:latest'
            }
        }
    }
}
