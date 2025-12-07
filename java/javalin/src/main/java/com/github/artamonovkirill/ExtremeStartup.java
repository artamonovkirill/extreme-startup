package com.github.artamonovkirill;

import io.javalin.Javalin;

public class ExtremeStartup {
    public static Javalin createApp() {
        return Javalin.create()
                .get("/", ctx -> {
                    var query = ctx.queryParam("q");
                    System.out.printf("Query is: %s%n", query);
                    ctx.result(query);
                });
    }

    public static void main(String... args) {
        createApp().start(7000);
    }
}
