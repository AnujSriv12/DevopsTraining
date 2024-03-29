pipeline {
    agent any
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
      post{
        success{
            echo 'The dev env build is success'
        }
        failure{
            echo 'The dev env build is failed'
        }
    }
}
