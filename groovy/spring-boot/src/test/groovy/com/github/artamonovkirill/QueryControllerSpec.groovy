package com.github.artamonovkirill

import com.tomtom.http.HttpClient
import com.tomtom.http.response.ResponseCode
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Specification

import static com.tomtom.http.response.ResponseCode.OK
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = ExtremeStartup)
class QueryControllerSpec extends Specification {

    @LocalServerPort
    def port
    HttpClient http

    def setup() {
        http = new HttpClient()
    }

    def 'exposes query endpoint'() {
        when:
        def response = http.get(url: "http://localhost:$port?q=bar")

        then:
        with(response) {
            statusCode == OK
            body == 'bar'
        }
    }

}
