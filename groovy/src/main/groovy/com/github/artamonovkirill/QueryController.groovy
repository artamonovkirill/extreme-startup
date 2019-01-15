package com.github.artamonovkirill

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class QueryController {

    @GetMapping
    def query(@RequestParam('q') query) {
        println "Query is: $query"
        'Hello'
    }

}
