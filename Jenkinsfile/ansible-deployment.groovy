pipeline {
    agent any
    environment {
        inventorypath = "/var/lib/jenkins/workspace/${JOB_NAME}/mnptec/inventory.ini"
        playbookpath  = "/var/lib/jenkins/workspace/${JOB_NAME}/mnptec/deployment.yml"

    }
    stages {
        stage ('checkout') {
            steps {
                checkout scm
            }
        }
        stage ('Deploy') {
            steps {
                sudo -u ansible ansible-playbook -i  ${inventorypath} ${playbookpath} -vvv
            }
        }
    }
}
