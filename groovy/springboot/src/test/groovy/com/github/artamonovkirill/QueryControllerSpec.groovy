package com.github.artamonovkirill

import com.tomtom.http.HttpClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Specification

import static com.tomtom.http.response.ResponseCode.OK
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = [ExtremeStartup, NoWebClient])
class QueryControllerSpec extends Specification {

    @LocalServerPort
    def port
    def http = new HttpClient()

    def 'exposes query endpoint'() {
        when:
        def response = http.get(url: "http://localhost:$port?q=bar")

        then:
        response.statusCode == OK
        response.body == 'bar'
    }

}
