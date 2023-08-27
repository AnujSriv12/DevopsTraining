pipeline {
    agent {label "anuj-test-app"}
    stages{
        stage ("GIT Clone") {
            steps {
                checkout scm
                echo 'The code has been cloned'
            }
        }
        stage ("Deployment") {
            steps {
                sh "cp /var/lib/jenkins/workspace/${JOB_NAME}/index.html /var/www/html"
            }
        }
    }
}
