package com.project.rest.controllers;

import com.project.rest.Trend;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrendsController {
    @RequestMapping("/trends")
    public Trend[] greeting() {
        return new Trend[]{
                new Trend("Bitcoin",
                "BTC",
                23),
                new Trend("Bitcoin",
                "BTC",
                23)};
    }
}
