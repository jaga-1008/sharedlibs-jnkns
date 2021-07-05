def call(nexusrepo){
  def pom = readMavenPom file: 'pom.xml'
  def repo = nexusrepo 
  def artifactId = pom.artifactId
  def groupId = pom.groupId
  nexusArtifactUploader artifacts: [[artifactId: artifactId, classifier: '', file: "target/${artifactId}-${pom.version}.war",
  type: 'war']],
  credentialsId: 'nexus3',
  groupId: groupId,
  nexusUrl: '172.31.9.150:8081',
  nexusVersion: 'nexus3',
  protocol: 'http',
  repository: repo,
  version: pom.version
                
}
