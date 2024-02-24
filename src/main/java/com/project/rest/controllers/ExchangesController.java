package com.project.rest.controllers;

import com.project.rest.Exchanges;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangesController {
    @RequestMapping("/exchanges")
    public Exchanges [] greeting(){
        return new Exchanges[]{new Exchanges("Binance",
                9,
                364578658725.0,
                67,
                45 ,
                new double[]{324,436,584,987,674})};
    }
}
