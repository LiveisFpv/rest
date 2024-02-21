package com.project.rest;

public class Deal {
    private final String date;
    private final String type;
    private final double price;
    private final double volume;
    private final String coin_name;
    private final String coin_code;
    public Deal(String date, String type, double price, double volume, String coin_name, String coin_code){
        this.date=date;
        this.type=type;
        this.price=price;
        this.volume=volume;
        this.coin_name=coin_name;
        this.coin_code=coin_code;
    }

    public double getVolume() {
        return this.volume;
    }

    public String getCoin_name() {
        return this.coin_name;
    }

    public String getCoin_code() {
        return this.coin_code;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }
}
