pipeline {
    agent any

    stages{

        stage('Git'){
            steps{
                echo 'Test git'
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'SSH_Github_Azure', url: 'git@github.com:ChocTitans/Sprinboot_Devops.git']]])	

            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Setup Environment - Ansible') {
            steps {
                echo 'Setuping....'
                ansiblePlaybook credentialsId: 'azureuser2_testVM_Java', disableHostKeyChecking: true, installation: 'AnsibleAzure', inventory: 'hosts.cfg', playbook: 'AnsibleDeploy.yml'
                sh 'docker build -t springboot'
                sh 'docker run -p 8080:8080 -d springboot'
                sh 'az vm open-port --port 8080 --resource-group DevopsJenskins --name devops'
            }
        }


        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }        
        







    }
}