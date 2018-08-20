project_name = "Proyecto-a/jenkins-pipeline-python-test1" 
repo = "https://github.com/jandres6579/prueba-test-1.git"
repo_name = "repo"

folder('Proyecto-a') {
    displayName('Proyect A')
    description('Folder for proyect A')
}

pipelineJob(project_name) {
    definition {
        triggers{
            scm('H/1 * * * *')
        }

        cpsScm{
            scm {
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
