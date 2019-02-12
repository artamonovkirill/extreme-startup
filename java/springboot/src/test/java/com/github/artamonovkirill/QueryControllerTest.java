package com.github.artamonovkirill;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {ExtremeStartup.class})
public class QueryControllerTest {

    @LocalServerPort
    int port;
    RestTemplate template = new RestTemplate();

    @Before
    public void setup() {
    }

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