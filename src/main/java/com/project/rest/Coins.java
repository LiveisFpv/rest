package com.project.rest;

import java.lang.reflect.Array;

public class Coins {
    private final String coin_name;
    private final String coin_code;
    private final double price;
    private final double h1;
    private final double h24;
    private final double d7;
    private final double market_cap;
    private final double volume;
    private final double last_price[];
    public Coins(String coin_name,String coin_code, double price,
                 double h1, double h24, double d7, double market_cap,
                 double volume, double last_price[]){
        this.coin_name=coin_name;
        this.coin_code=coin_code;
        this.price=price;
        this.h1=h1;
        this.h24=h24;
        this.d7=d7;
        this.market_cap=market_cap;
        this.volume=volume;
        this.last_price=last_price;
    }
    public String getCoin_name(){
        return this.coin_name;
    }
    public String getCoin_code(){
        return this.coin_code;
    }
    public double getPrice() {
        return this.price;
    }
    public double getH1(){
        return this.h1;
    }
    public double getH24(){
        return this.h24;
    }
    public double getD7(){
        return this.d7;
    }
    public double getMarket_cap(){
        return this.market_cap;
    }
    public double getVolume(){
        return this.volume;
    }
    public double[] getLast_price(){
        return this.last_price;
    }
}
