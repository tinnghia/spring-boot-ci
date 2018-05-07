node("master"){
    withMaven {
        try {
            notifySlack('STARTED')

            stage("Checkout") {
                //git url: 'https://github.com/tinnghia/spring-boot-ci.git', credentialsId: 'tinnghia', branch: 'master'

                checkout scm
            }

            stage("Build") {
                sh "mvn clean install"
            }
        }catch(e) {
            echo "FAILURE"
            currentBuild.result = "FAILURE"
            throw e
        }finally {
            echo currentBuild.result
            notifySlack(currentBuild.result)
        }
    }
}

def notifySlack(String buildStatus = 'STARTED') {
    buildStatus = buildStatus ?: "SUCCESS"
    def colorMap = [ 'STARTED': '#F0FFFF', 'SUCCESS': '#008B00', 'FAILURE': '#FF0000' ]
    def msg = "${buildStatus}: `${env.JOB_NAME}` \n#${env.BUILD_NUMBER}:${env.BUILD_URL}"

    def colorName = colorMap[buildStatus]

    slackSend(color:  colorName, message: msg)
}