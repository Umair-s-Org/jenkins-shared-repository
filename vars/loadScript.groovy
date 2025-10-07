def call(Map config = [:]) {
    // Fetch any script from resources/scripts/
    def scriptData = libraryResource "scripts/${config.name}"
    writeFile file: config.name, text: scriptData
    sh "chmod +x ./${config.name}"
}
