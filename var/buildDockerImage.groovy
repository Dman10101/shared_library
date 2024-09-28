def call(dockerImage, buildNumber) {
    echo "Building Docker image..."
    sh "docker build -t ${dockerImage}:${buildNumber} ."
}
