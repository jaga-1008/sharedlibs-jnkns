def call(nexusrepo){
  def pom = readMavenPom file: 'pom.xml'
  def repo = nexusrepo 
  def artifactid = pom.artifactid
  def groupid = pom.groupid
  nexusArtifactUploader artifacts: [[artifactId: artifactid, classifier: '', file: "target/${artifactid}-${pom.version}.war",
  type: 'war']],
  credentialsId: 'nexus3',
  groupId: groupid,
  nexusUrl: '172.31.9.150:8081',
  nexusVersion: 'nexus3',
  protocol: 'http',
  repository: repo,
  version: pom.version
                
}
