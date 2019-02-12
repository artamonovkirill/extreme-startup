import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            def query = context.request.queryParams.find { it.key == 'q' }
            println "Query is: ${query?.value}"
            render query?.value ?: 'Hello!'
        }
    }
}
