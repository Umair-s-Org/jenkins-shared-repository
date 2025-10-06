def call(String buildStatus = 'STARTED') {
    buildStatus = buildStatus ?: 'SUCCESS'


    // Map status to color
    def color = buildStatus == 'SUCCESS'  ? '#47ec05' :
                buildStatus == 'UNSTABLE' ? '#d5ee0d' :
                                            '#ec2805'


    // Construct message
    def msg = "${buildStatus}: ${env.JOB_NAME} #${env.BUILD_NUMBER}\n${env.BUILD_URL}"
    slackSend color: color, message: msg
}
