pipeline {
    agent {
        kubernetes {
            label 'docker-kubectl-agent'
        }
    }

    stages {
        stage('build') {
            steps {
                container('kubectl') {
                    script {
                        sh '''
                            kubectl apply -f .
                        '''
                    }
                }
            }
        }
    }
}