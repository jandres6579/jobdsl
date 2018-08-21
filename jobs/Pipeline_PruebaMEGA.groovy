project_name = "dls-seed-Pipeline-PruebaMega" 
repo = "http://odinsgitlab.ddns.net/IoTAS/conector-mega.git"
repo_name = "repo1" 

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
                        credentials('Ri73VTzGte2cwnSZbuiZ')
                    }
//                  scriptPath("Jenkinsfile")

                }
            }
        }
    }
}