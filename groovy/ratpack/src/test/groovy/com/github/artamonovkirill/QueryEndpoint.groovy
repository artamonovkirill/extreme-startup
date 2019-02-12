package com.github.artamonovkirill

import com.tomtom.http.HttpClient
import ratpack.groovy.Groovy
import ratpack.server.RatpackServer
import spock.lang.Specification

import static com.tomtom.http.response.ResponseCode.OK

class QueryEndpoint extends Specification {

    RatpackServer server
    def http = new HttpClient()

    def setup() {
        server = RatpackServer.start(Groovy.Script.appWithArgs())
    }

    def 'exposes query endpoint'() {
        when:
        def response = http.get(url: 'http://localhost:5050')

        then:
        with(response) {
            statusCode == OK
            body == 'Hello!'
        }
    }

    def 'returns query if provided'() {
        when:
        def response = http.get(url: 'http://localhost:5050?q=bar')

        then:
        with(response) {
            statusCode == OK
            body == 'bar'
        }
    }

    def cleanup() {
        server?.stop()
    }

}
