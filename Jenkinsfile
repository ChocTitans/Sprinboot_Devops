pipeline {
    agent any

    stages{

        stage('Git'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'SSH_Github_Azure', url: 'git@github.com:ChocTitans/Sprinboot_Devops.git']]])	

            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker build and Push'){
            steps{
                echo 'Building & Pushing ...'
                withDockerRegistry([ credentialsId: "DockerHamza", url: "" ]) {
				    sh 'docker build -t eltitans/springboot:latest .'
                    sh "docker push eltitans/springboot:latest"

               }
            }
        }
        /*stage('Setup Environment - Ansible') {
            steps {
                echo 'Setuping....'
                ansiblePlaybook credentialsId: 'azureuser2_testVM_Java', disableHostKeyChecking: true, installation: 'AnsibleAzure', inventory: 'hosts.cfg', playbook: 'AnsibleDeploy.yml'
            }
        }*/


  
        







    }
}