pipeline {
    agent {label "anuj-test-app"}
    stages{
        stage ("GIT Clone") {
            steps {
                checkout scm
                sh "rm -rf .git"
                echo 'The code has been cloned'
            }
        }
        stage ("Deployment") {
            steps {
                sh "sudo cp /var/lib/jenkins/workspace/${JOB_NAME}/index.html /var/www/html"
            }
        }
    }
}
