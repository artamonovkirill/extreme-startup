package com.github.artamonovkirill;

import java.util.Optional;

import static java.lang.String.format;
import static spark.Spark.get;

public class ExtremeStartup {
    public static void main(String... args) {
        get("/", (request, response) -> {
            String query = request.queryParams("q");
            System.out.println(format("Query is: %s", query));
            return query;
        });
    }
}
