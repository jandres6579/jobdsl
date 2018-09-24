//Documentación: https://jenkinsci.github.io/job-dsl-plugin/#

project_name = "dls-seed-MultiBranchPipeline_" 
repo = "https://github.com/jandres6579/jenkinsNode.git"

multibranchPipelineJob(project_name) {
    //Indica la periodicidad para ver si ha cambiado algo en los fuentes del repositorio al que está asociado (scm)
    //Expresado en minutos
    triggers {
        periodic(1440)
    }

    //Vincula con el repositorio de GitHub
    branchSources {
        git {
            remote(repo)
        }
    }
    
    orphanedItemStrategy {
        //Trims dead items by the number of days or the number of items.
        discardOldItems {
            //Days to keep old items. if not empty, old items are only kept up to this number of days
            //daysToKeep(10)
            //Max # of old items to keep. if not empty, only up to this number of old items are kept
            numToKeep(5) //¿es posible que se pierda por lo que pueda haber en el jenkinsfile.
        }
    }
}
