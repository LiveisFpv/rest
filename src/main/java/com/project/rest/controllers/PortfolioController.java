package com.project.rest.controllers;

import com.project.rest.models.Coin;
import com.project.rest.models.Deal;
import com.project.rest.models.Portfolio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {
    @RequestMapping(value = "/portfolio")
    public Portfolio greeting(){
        return new Portfolio(
                new Coin[]{
                        new Coin("Bitcoin","BTC",34,3289476278.0,new double[]{324,436,584,987,674})},
                new Deal[]{
                        new Deal("2024-02-02T12:33:33","sell",3543256,3,"Bitcoin","BTC")
                },
                new double[]{324.0,436.0,584.0,987.0,674.0},
                new double[]{324.0,436.0,584.0,987.0,674.0},
                345,
                345);
    }
}
