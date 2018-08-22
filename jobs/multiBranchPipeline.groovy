//Documentación: https://jenkinsci.github.io/job-dsl-plugin/#

project_name = "dls-seed-MultiBranchPipeline_Scan1mins_BuildIfChanges" 
repo = "https://github.com/jandres6579/prueba-test-1.git"

multibranchPipelineJob(project_name) {
    //Indica la periodicidad para ver si ha cambiado algo en los fuentes del repositorio al que está asociado (scm)
    triggers {
        periodic(1)
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
            numToKeep(20)
        }
    }
}