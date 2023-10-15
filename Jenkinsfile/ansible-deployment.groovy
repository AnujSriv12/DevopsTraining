pipeline {
    agent any
    environment {
        inventorypath = "/var/lib/jenkins/workspace/${JOB_NAME}/Jenkinsfile/inventory.ini"
        playbookpath  = "/var/lib/jenkins/workspace/${JOB_NAME}/Jenkinsfile/deployment.yml"
    }
    stages {
        stage ('checkout') {
            steps {
                checkout scm
            }
        }
        stage ('Deploy') {
            steps {
                sh '''
                sudo -u ansible ansible-playbook -i ${inventorypath} ${playbookpath} -vvv
                '''
            }
        }
    }
}
