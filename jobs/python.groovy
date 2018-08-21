project_name = "dls-seed-Pipeline-Scan1mins_Build1Hour" 
/*
Si quisiesemos incluir el job en una carpeta. Cambiaríamos la línea anteior por esta...
project_name = "Proyecto-a/jenkins-pipeline-python-test" 
*/
repo = "https://github.com/jandres6579/prueba-test-1.git"
repo_name = "repo" 

/*
Si quisiesemos incluir el job en una carpeta. Añadiríamos esto...
folder('Proyecto-a') {
    displayName('Proyect A')
    description('Folder for proyect A')
}
*/

pipelineJob(project_name) {
    definition {
        triggers{
            scm('H/1 * * * *')
            cron('H/30 * * * *')
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
