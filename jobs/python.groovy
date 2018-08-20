proyect_name = "jenkins-pipeline-python" 
repo = "https://github.com/jandres6579/prueba-test-1.git"
repo_name = "repo" 

pipelineJob(proyect_name) {
    definition {
        triggers {
            scm('H/1 * * * *')
        }

        cpsScm{
            scm{
                git {
                    remote {
                        name(repo_name)
                        url(repo)
                    }
                    scriptPath("Jenkinsfile")
                }
            }
        }
    }
}
