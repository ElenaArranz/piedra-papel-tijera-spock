pipeline {
    agent any

    stages {
        stage('Github') {
            steps {
                echo 'Hello World'
            }
        }
        stage('parallel') {
             parallel {
            stage('Compile') {
                steps {
                    echo 'Hello World'
                }
            }
            stage('Download') {
                steps {
                     sleep 10
                    echo 'Hello World'
                }
            }
        }
        }

       stage('Notify') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
