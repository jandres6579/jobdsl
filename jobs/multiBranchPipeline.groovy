multibranchPipelineJob('python-deploy') {
    triggers {
        periodic(1)
    }

    branchSources {
        git {
            remote('https://github.com/jandres6579/prueba-test-1.git')
        }
    }
    
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}