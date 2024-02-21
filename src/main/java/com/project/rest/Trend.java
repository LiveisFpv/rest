package com.project.rest;

public class Trend {
    private final String coin_name;
    private final String coin_code;
    private final double h24;
    public Trend(String coin_name,String coin_code,double h24){
        this.coin_name=coin_name;
        this.coin_code=coin_code;
        this.h24=h24;
    }

    public String getCoin_name() {
        return this.coin_name;
    }

    public String getCoin_code() {
        return this.coin_code;
    }

    public double getH24() {
        return this.h24;
    }
}
