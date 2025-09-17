pipeline {
    agent {
        kubernetes {
            label 'docker-kubernetes-agent'
        }
    }

    stages {
        stage('build') {
            steps {
                container('kubernetes') {
                    script {
                        sh """
                            kubectl apply -f .
                        """
                    }
                }
            }
        }
    }
}