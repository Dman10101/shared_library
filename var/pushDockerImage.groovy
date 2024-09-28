def call(dockerImage, buildNumber) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        echo "Pushing Docker image to Docker Hub..."
        sh "echo \"$PASSWORD\" | docker login -u \"$USERNAME\" --password-stdin"
        sh "docker push ${dockerImage}:${buildNumber}"
    }
}
