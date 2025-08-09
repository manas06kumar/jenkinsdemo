pipeline {
    agent any
     tools {
	    maven 'M3'           // From Manage Jenkins → Tools
  		jdk 'JDK17'          // Optional if your agent already has Java
 	 }
 	   environment {
    IMAGE = 'jenkinsdemo:latest'
  }
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
