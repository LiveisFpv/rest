package com.project.rest;

public class Portfolio {
    private final Coin Coins[];
    private final Deal Deals[];
    private final double profile_volume_usd[];
    private final double profile_volume_btc[];
    private final double current_volume_usd;
    private final double current_volume_btc;
    public Portfolio(Coin Coins[],Deal Deals[],double profile_volume_usd[], double profile_volume_btc[],double current_volume_usd, double current_volume_btc){
        this.Coins=Coins;
        this.Deals=Deals;
        this.profile_volume_usd=profile_volume_usd;
        this.profile_volume_btc=profile_volume_btc;
        this.current_volume_usd=current_volume_usd;
        this.current_volume_btc=current_volume_btc;
    }

    public Coin[] getCoins() {
        return this.Coins;
    }

    public Deal[] getDeals() {
        return this.Deals;
    }

    public double getCurrent_volume_btc() {
        return this.current_volume_btc;
    }

    public double getCurrent_volume_usd() {
        return this.current_volume_usd;
    }

    public double[] getProfile_volume_btc() {
        return this.profile_volume_btc;
    }

    public double[] getProfile_volume_usd() {
        return this.profile_volume_usd;
    }
}
