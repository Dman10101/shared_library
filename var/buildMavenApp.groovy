def call() {
    echo "Building Maven project..."
    sh 'mvn clean install'
}
