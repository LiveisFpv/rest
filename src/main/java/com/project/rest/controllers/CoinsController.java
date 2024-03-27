package com.project.rest.controllers;

import com.project.rest.models.Coins;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinsController {
    @RequestMapping("/coins")
    public Coins greeting(@RequestParam(value="Coin", required=false, defaultValue="Bitcoin") String Coin) {
        return new Coins(Coin,
                "BTC",
                50000,
                -25,
                -23,
                56,
                2000000000,
                400000000,
                new double[]{324, 436, 584, 987, 674});
    }
}
