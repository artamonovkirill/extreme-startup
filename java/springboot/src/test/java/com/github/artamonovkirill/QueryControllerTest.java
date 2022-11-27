package com.github.artamonovkirill;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {ExtremeStartup.class})
public class QueryControllerTest {

    @LocalServerPort
    int port;
    RestTemplate template = new RestTemplate();

    @Test
    public void exposesQueryEndpoint() {
        //given
        var uri = format("http://localhost:%d?q=foo", port);

        //when
        var result = template.getForObject(uri, String.class);

        //then:
        assertThat(result).isEqualTo("foo");
    }

}