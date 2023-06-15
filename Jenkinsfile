pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/mohamedamineboughrara/erp_project', credentialsId: '04d2b06c-1242-4e29-bec6-34e40f5735ec']]
                ])
            }
        }
           stage('Build GestionBdg microservice') {
                            steps {
                                dir(GestionBdg) {
                                    sh 'mvn clean compile package'
                                    sh 'mvn test'
                                    sh 'docker build -t mohamedamineboughrara/gestionbdg-1.0.0.jar .'
                                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                                    sh 'mvn org.owasp:dependency-check-maven:check'

                                }
                            }
                        }

        stage('Build Leave Project') {
            steps {
                dir('leave') {
                    sh 'mvn clean compile package'
                    sh 'mvn test'
                    sh 'docker build -t mohamedamineboughrara/leave .'
                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                    sh 'mvn org.owasp:dependency-check-maven:check'
                    archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)

                }
            }
        }

        stage('Build MicroServiceProjet Project') {
            steps {
                dir('microServiceProjet (1)') {
                    sh 'mvn clean compile package'
                    sh 'mvn test'
                    sh 'docker build -t mohamedamineboughrara/micrpserviceprojet .'
                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                    sh 'mvn org.owasp:dependency-check-maven:check'

                }
            }
        }

    }
}
