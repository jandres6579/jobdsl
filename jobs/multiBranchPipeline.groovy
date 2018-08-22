project_name = "dls-seed-MultiBranchPipeline_Scan1mins_BuildIfChanges" 
repo = "https://github.com/jandres6579/prueba-test-1.git"

multibranchPipelineJob(project_name) {
    triggers {
        periodic(1)
    }

    branchSources {
        git {
            remote(repo)
        }
    }
    
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}