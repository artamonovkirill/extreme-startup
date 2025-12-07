package com.github.artamonovkirill;

import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExtremeStartupTest {

    @Test
    void exposesQueryEndpoint() {
        JavalinTest.test(ExtremeStartup.createApp(), (server, client) -> {
            var response = client.get("/?q=nothing%20else%20matters");
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).isEqualTo("nothing else matters");
        });
    }
}
