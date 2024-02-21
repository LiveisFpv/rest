package com.project.rest;

public class Exchanges {
    private final String name;
    private final double score;
    private final double volume24h;
    private final double markets;
    private final double coins;
    private final double last_volume[];

    public Exchanges(String name,double score,double volume24h,double markets,double coins, double last_volume[]){
        this.name=name;
        this.score=score;
        this.volume24h=volume24h;
        this.markets=markets;
        this.coins=coins;
        this.last_volume=last_volume;
    }

    public double getCoins() {
        return this.coins;
    }

    public double getMarkets() {
        return this.markets;
    }

    public double getScore() {
        return this.score;
    }

    public double getVolume24h() {
        return this.volume24h;
    }

    public double[] getLast_volume() {
        return this.last_volume;
    }

    public String getName() {
        return this.name;
    }
}
