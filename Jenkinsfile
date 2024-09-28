// Load the shared library
@Library('my-shared-library') _

pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials') // Docker Hub credentials in Jenkins
        DOCKER_IMAGE = 'yourdockerhubusername/yourapp'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Using the shared library function for checkout
                    checkout scm
                }
            }
        }

        stage('Build & Install Dependencies') {
            steps {
                script {
                    // Use a shared library function to build the app
                    buildMavenApp()
                }
            }
        }

        stage('Test Coverage') {
            steps {
                script {
                    // Use a shared library function for test coverage
                    runTestCoverage()
                }
            }
        }

        stage('Test Application') {
            steps {
                script {
                    // Run tests using shared library function
                    runTests()
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image using shared library function
                    buildDockerImage(DOCKER_IMAGE, env.BUILD_NUMBER)
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Push the Docker image to Docker Hub using shared library function
                    pushDockerImage(DOCKER_IMAGE, env.BUILD_NUMBER)
                }
            }
        }
    }

    post {
        success {
            script {
                // Archive artifacts if the build succeeds using shared library function
                archiveArtifactsAndNotify()
            }
        }
        failure {
            script {
                // Notify if the build fails
                sendFailureNotification()
            }
        }
    }
}
