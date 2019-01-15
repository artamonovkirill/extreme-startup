package com.github.artamonovkirill;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @GetMapping
    public String query(@RequestParam("q") String query) {
        System.out.println("Query is: " + query);
        return "Hello";
    }

}
