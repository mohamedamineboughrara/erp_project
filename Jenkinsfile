pipeline {
    agent any
    stages {
        stage('projects') {
            steps {
                dir('microServiceProjet (1)') {
                    script {
                        // Execute Jenkinsfile in subfolder1
                        load('Jenkinsfile')
                    }
                }
            }
        }
        stage('leave') {
            steps {
                dir(leave) {
                    script {
                        // Execute Jenkinsfile in subfolder2
                        load('Jenkinsfile')
                    }
                }
            }
        }
    }
}
