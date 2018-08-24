//Documentación: https://jenkinsci.github.io/job-dsl-plugin/#

project_name = "dls-seed-Pipeline-GitHub_Scan1Day_Build30Mins" 
/*
Si quisiesemos incluir el job en una carpeta. Cambiaríamos la línea anteior por esta...
project_name = "Proyecto-a/jenkins-pipeline-python-test" 
*/
repo = "https://github.com/jandres6579/jenkinsNode.git"
repo_name = "repo3" 

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
            //Indica la periodicidad para ver si ha cambiado algo en los fuentes del repositorio al que está asociado (scm)
            //Indica la periodicidad para lanzar el build (cron)
            scm('@daily')
            cron('H/30 * * * *')
        }

        cpsScm{
            scm {
                git {
                    remote {
                        name(repo_name)
                        url(repo)
                        credentials('GitLab_user')
                    }

                    //Indica el fichero Jenkinsfile
                    scriptPath("Jenkinsfile")
                }
            }
        }
    }

    //logRotator(int daysToKeep = -1, int numToKeep = -1, int artifactDaysToKeep = -1, int artifactNumToKeep = -1)
    logRotator {
        //If specified, build records are only kept up to this number of days.
        //daysToKeep(5)
        //If specified, only up to this number of build records are kept.
        numToKeep(25)
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
        //dontNotifyEveryUnstableBuild --> Dont send e-mail for every unstable build
        //sendToIndividuals --> Send separate e-mails to individuals who broke the build
        mailer('jasanchez@odins.es', false, false)
    }
}
