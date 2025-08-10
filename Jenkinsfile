pipeline {
  agent any
  options { skipDefaultCheckout(true) }     // we'll control checkout
  tools { maven 'M3'; jdk 'JDK17' }
  environment { IMAGE = 'jenkinsdemo:latest' }

  stages {
    stage('Prep & Checkout') {
      steps {
        deleteDir() // clean workspace to avoid "not a git dir"
        git branch: 'main', url: 'https://github.com/manas06kumar/jenkinsdemo.git'
      }
    }

    stage('Verify Tooling') {
      steps {
        sh '''
          git --version
          mvn -v
          id
          ls -l /var/run/docker.sock || true
          docker version
        '''
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t $IMAGE .'
      }
    }

    stage('Run Container') {
      steps {
        sh '''
          docker rm -f jenkinsdemo || true
          # Map ports as your app needs; change right side if your app listens on 8080
          docker run -d --name jenkinsdemo -p 8081:8500 $IMAGE
        '''
      }
    }
  }

  post {
    failure {
      echo 'Build failed. Docker logs (if container exists):'
      sh 'docker logs jenkinsdemo || true'
    }
  }
}
