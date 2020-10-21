pipeline {
    agent any
    triggers { cron('@daily') }
parameters{
    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
}
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Tanya_maven_3.6.0"
    }

    stages {
        stage('Build and test') {
            steps {
                // Get some code from a GitHub repository
//                git 'ssh://git@github.com:TanyaPylypchuk/TestApiProject.git'
                //for test

                // Run Maven on a Unix agent.
                sh "./gradlew clean build --info"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/build/test-results/test/TEST-*.xml'
//                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
