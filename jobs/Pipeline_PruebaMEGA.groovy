project_name = "dls-seed-freeStyle-PruebaMega" 
repo = "http://odinsgitlab.ddns.net/IoTAS/conector-mega.git"
repo_name = "repo1" 

freeStyleJob(project_name) {

    triggers{
        scm('H/3 * * * *')
        cron('H/35 * * * *')
    }

    scm {
        git {
            remote {
                name(repo_name)
                url(repo)
                credentials('Ri73VTzGte2cwnSZbuiZ')
            }
        }
    }
}
