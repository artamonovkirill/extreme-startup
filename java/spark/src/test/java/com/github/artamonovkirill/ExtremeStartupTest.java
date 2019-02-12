package com.github.artamonovkirill;

import org.junit.jupiter.api.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import static java.net.http.HttpClient.newHttpClient;
import static org.assertj.core.api.Assertions.assertThat;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

class ExtremeStartupTest {

    HttpClient http = newHttpClient();

    @BeforeAll
    static void setup() {
        ExtremeStartup.main();
        awaitInitialization();
    }

    @Test
    void exposesQueryEndpoint() throws Exception {
        //given
        var uri = new URI("http://localhost:4567?q=nothing%20else%20matters");
        var request = HttpRequest.newBuilder(uri).GET().build();

        //when
        var result = http.send(request, BodyHandlers.ofString());

        //then:
        assertThat(result.statusCode()).isEqualTo(200);
        assertThat(result.body()).isEqualTo("nothing else matters");
    }

    @AfterAll
    static void cleanup() {
        stop();
    }

}
