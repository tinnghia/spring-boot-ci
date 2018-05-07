node("master"){
    withMaven {
        stage("Checkout") {
            git url: 'https://github.com/tinnghia/spring-boot-ci.git', credentialsId: 'tinnghia', branch: 'master'
        }

        stage("Build") {
            sh "mvn clean install"
        }
    }
}