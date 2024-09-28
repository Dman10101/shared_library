def call() {
    echo "Running test coverage..."
    sh 'mvn test'
    jacoco execPattern: '**/target/*.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java'
}
