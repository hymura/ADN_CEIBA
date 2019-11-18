pipeline{
 
		agent {
			label 'Slave_Induccion'
		}
		
		options {
			buildDiscarder(logRotator(numToKeepStr:'5'))
			disableConcurrentBuilds()
		}
		
		tools{
			jdk 'JDK8_Centos'
			gradle 'Gradle4.5_Centos'
		}

		stages {

			stage('Checkout Git'){
				steps{
				   checkout([
				   $class: 'GitSCM', 
				   branches: [[name: '*/master']], 
				   doGenerateSubmoduleConfigurations: false, 
				   extensions: [], 
				   gitTool: 'Git_Centos', 
				   submoduleCfg: [], 
				   userRemoteConfigs: [[
						credentialsId: 'GitHub_alexgomez636', 
						url: 'https://github.com/hymura/AprobacionOC'
						]]])
				}
			}
			 
			stage('Build project') { 
			   steps { 
					 sh 'chmod +x gradlew'
					sh './gradlew --b ./build.gradle clean'
					sh './gradlew --b ./build.gradle build -x test'
				}
			}

			stage('Unit Test & Coverage') {
				steps {
				    sh './gradlew --b ./build.gradle test'
				    sh './gradlew --b ./build.gradle jacocoTestReport'
				}
			}          
			
			stage('Static Code Analysis') {
			steps{
				echo "------------>Sonar<------------"
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
				}
			}
		}

		}
    
		post { 
			failure { 
				mail( to: 'alex.gomez@ceiba.com.co' ,
					body: "Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/n Please go to ${env.BUILD_URL} and verify the build", 
					subject: "ERROR CI: Project name → ${env.JOB_NAME}")
            } 
        }
    }  