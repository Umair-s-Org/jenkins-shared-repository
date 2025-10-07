def vulnerability(Map config = [:]) {
    // Load the parameterized script into the workspace
    loadScript(name: 'trivy.sh')
    sh "./trivy.sh ${config.imageName} ${config.severity} ${config.exitCode}"
}


def reportsConverter() {
    sh 'trivy convert --format template --template "@/usr/local/share/trivy/templates/html.tpl"'
}
