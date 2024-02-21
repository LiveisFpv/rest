package com.project.rest;

public class Coin {
    private final String coin_name;
    private final String coin_code;
    private final double volume;
    private final double usd_price;
    private final double last_price[];
    public Coin(String coin_name,String coin_code,double volume, double usd_price, double last_price[]){
        this.coin_name=coin_name;
        this.coin_code=coin_code;
        this.volume=volume;
        this.usd_price=usd_price;
        this.last_price=last_price;
    }

    public String getCoin_code() {
        return this.coin_code;
    }

    public String getCoin_name() {
        return this.coin_name;
    }

    public double getUsd_price() {
        return this.usd_price;
    }

    public double getVolume() {
        return this.volume;
    }

    public double[] getLast_price() {
        return this.last_price;
    }
}
