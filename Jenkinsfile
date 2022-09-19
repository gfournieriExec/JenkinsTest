dev gv 

pipeline {
    agent any

    environment {
        NEW_VERSION = '1.3.0'
        // SERVER_CREDENTIALS = credentials('server-credentials')
    }

    // tools{
    //     maven 'Maven'
    // }

    parameters {
        // string (name :'VERSION', defaultValue : '', description: 'version to deploy on prod')
        choice (name: 'VERSION', choices : ['1.1.0','1.2.0','1.3.0'], description : '')
        booleanParam(name : 'executeTests', defaultValue: true, description : '' )
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                // when{
                //     expression {
                //         BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
                //     }
                // }
                script {
                    gv.buildApp()
                }
                echo "building version ${NEW_VERSION }"
                // sh "mvn install"
            }
        }
        stage('test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                    script {
                        gv.testApp()
                    }
            }
        }
        stage('deploying') {
            steps {
                    script {
                        gv.deployingApp()
                    }
                // echo "deploying with ${SERVER_CREDENTIALS}"
                // sh "${SERVER_CREDENTIALS}"
                // withCredentials([
                //     usernamePassword(credentials : 'server-credentials', usernameVariable : USER, passwordVariable : PWD )
                // ]){

                // echo "some script ${USER} ${PWD}"

                // }
            }
        }
    }
    // post {
    //     always {

    //     }

    //     success {

    //     }

    //     failure {

    //     }

    //     //build statues or build status change
    // }
} 