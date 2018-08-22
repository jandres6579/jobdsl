project_name = "dls-seed-freeStyle-PruebaMega" 
repo = "http://odinsgitlab.ddns.net/IoTAS/conector-mega.git"
repo_name = "repo1" 

freeStyleJob(project_name) {

    triggers{
        scm('H/3 * * * *')
        cron('H/15 * * * *')
    }

    scm {
        git {
            remote {
                name(repo_name)
                url(repo)
                credentials('GitLab_user')
            }
        }
    }

    steps {
        python {
            shell('echo Accede al directorio pruebas.')
            shell('cd pruebas')
            shell('echo Lanza ejecutable en segundo plano')
            command('python generaFichero_ResultadoPruebas.py &')
            shell('echo Vuelve al directorio original.')
            shell('cd ..')
        }
    }
}
