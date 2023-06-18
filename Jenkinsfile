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
         stage('Build Api-gateway ') {
                                            steps {
                                                dir('Aoi-gateway') {
                                                    sh 'mvn clean compile package'
                                                    sh 'mvn sonar:sonar   -Dsonar.projectKey=Api-gateway -Dsonar.host.url=http://localhost:9000 -Dsonar.login=ed2e81b29f1b3f6ff5320459e72ab510fb107c1a '
                                                    sh 'docker build -t mohamedamineboughrara/aoi-gateway-1.0.0.jar .'
                                                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                                                    sh 'mvn org.owasp:dependency-check-maven:check'
                                                    archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                                }
                                            }
                                        }
                                         stage('Build Appointment   microservice') {
                                                                                      steps {
                                                                                         dir('rendezVous') {
                                                                                            sh 'mvn clean compile package'
                                                                                            sh 'mvn test'
                                                                                            sh 'docker build -t mohamedamineboughrara/rendezvous-1.0.0.jar .'
                                                                                            sh 'docker login -u mohamedamineboughrara -p azerty123'
                                                                                            sh 'mvn org.owasp:dependency-check-maven:check'
                                                                                            archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                                                                                                               }
                                                                                                                              }
                                                                                                                              }
                                        stage('Build Material  microservice') {
                                              steps {
                                                 dir('Material') {
                                                    sh 'mvn clean compile package'
                                                    sh 'mvn test'
                                                    sh 'docker build -t mohamedamineboughrara/material-1.0.0.jar .'
                                                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                                                    sh 'mvn org.owasp:dependency-check-maven:check'
                                                    archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                                                                       }
                                                                                      }
                                                                                      }
                                          stage('Build GestionDocumentsDemander  microservice') {
                                                                                    steps {
                                                                                        dir('GestionDocumentsDemander') {
                                                                                        sh 'mvn clean compile package'
                                                                                        sh 'mvn test'
                                                                                        sh 'docker build -t mohamedamineboughrara/gestiondocumentsdemander-1.0.0.jar .'
                                                                                        sh 'docker login -u mohamedamineboughrara -p azerty123'
                                                                                        sh 'mvn org.owasp:dependency-check-maven:check'
                                                                                        archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                                                                                            }
                                                                                                           }
                                                                                                           }
                                          stage('Build interview  microservice') {
                                                                            steps {
                                                                                dir('interview') {
                                                                                    sh 'mvn clean compile package'
                                                                                    sh 'mvn test'
                                                                                    sh 'docker build -t mohamedamineboughrara/interview-1.0.0.jar .'
                                                                                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                                                                                    sh 'mvn org.owasp:dependency-check-maven:check'
                                                                                    archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                                                                }
                                                                            }
                                                                        }
        stage('Build GestionCRAs microservice') {
                                    steps {
                                        dir('GestionCRAsBack-master') {
                                            sh 'mvn clean compile package'
                                            sh 'mvn test'
                                            sh 'docker build -t mohamedamineboughrara/gestioncras-1.0.0.jar .'
                                            sh 'docker login -u mohamedamineboughrara -p azerty123'
                                            sh 'mvn org.owasp:dependency-check-maven:check'
                                            archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                        }
                                    }
                                }

           stage('Build GestionBdg microservice') {
                            steps {
                                dir('GestionBdg') {
                                    sh 'mvn clean compile package'
                                    sh 'mvn test'
                                    sh 'docker build -t mohamedamineboughrara/gestionbdg-1.0.0.jar .'
                                    sh 'docker login -u mohamedamineboughrara -p azerty123'
                                    sh 'mvn org.owasp:dependency-check-maven:check'
                                    archiveArtifacts(artifacts: 'target/dependency-check-report.html', fingerprint: true)


                                }
                            }
                        }

        stage('Build Leave Project micorservice') {
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
