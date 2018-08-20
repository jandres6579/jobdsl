listView('python') {
    description('Python pipelines')
    jobs {
        regex(/.*python.*/)
    }
    recurse()
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}