project_name = "dls-seed-freeStyle-PruebaMega" 
repo = "http://odinsgitlab.ddns.net/IoTAS/conector-mega.git"
repo_name = "repo1" 

freeStyleJob(project_name) {

    //Indica la periodicidad para ver si ha cambiado algo en los fuentes del repositorio al que está asociado (scm)
    //Indica la periodicidad para lanzar el build (cron)
    triggers{
        scm('H/3 * * * *')
        cron('H/15 * * * *')
    }

    //Vincula con el repositorio de GitLab con las Credenciales configuradas en Jenkins
    scm {
        git {
            remote {
                name(repo_name)
                url(repo)
                credentials('GitLab_user')
            }
        }
    }

    //Añadir fichero con los comandos a ejecutar en el Shell.
    steps {
        shell(readFileFromWorkspace('jobs/scripts/ejemplo_script.sh'))
    }

    wrappers {
        //Delete workspace before build starts
        preBuildCleanup()
        //Add timestamps to the Console Output
        timestamps()
    }

    publishers {
        //Sends email notifications.
        //mailer(String recipients, Boolean dontNotifyEveryUnstableBuild = false, Boolean sendToIndividuals = false)
        //dontNotifyEveryUnstableBuild --> Send e-mail for every unstable build
        //sendToIndividuals --> Send separate e-mails to individuals who broke the build
        mailer('jasanchez@odins.es', true, false)
    }
}
