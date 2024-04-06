package com.project.rest.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "exchanges")
public class Exchanges {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private final String name;
    @Column(name="score")
    private final double score;
    @Column(name="volume24h")
    private final double volume24h;
    @Column(name="markets")
    private final double markets;
    @Column(name="coins")
    private final double coins;
    @Column(name="last_volume")
    private final double last_volume[];

    public Exchanges(String name,double score,double volume24h,double markets,double coins, double last_volume[]){
        this.name=name;
        this.score=score;
        this.volume24h=volume24h;
        this.markets=markets;
        this.coins=coins;
        this.last_volume=last_volume;
    }

    public Integer getId() {
        return this.id;
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

    public void setid(Integer id) {
        this.id=id;
    }
}
