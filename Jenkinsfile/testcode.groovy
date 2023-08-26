pipeline {
    agent {label "anuj-test-app"}
    stages {
        stage('OS') {
            steps {
                sh "cat /etc/os-release"
                echo 'This is system OS'
            }
        }
        stage('users') {
            steps {
                sh "cat /etc/passwd"
                echo 'These are users'
            }
        }
         stage('Create a file') {
            steps {
                sh '''
                sudo touch /tmp/newfile.txt
                '''
                echo 'File created inside tmp'
            }
        }
    }
    post{
        success{
            echo 'The build is success'
        }
        failure{
            echo 'The build is failed'
        }
    }
}
