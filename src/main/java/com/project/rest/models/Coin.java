package com.project.rest.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "coin")
public class Coin {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="portfolio_coin_id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true) // Только ID будет сериализован
    @JsonIgnore
    private Portfolio portfolio_coin;
    @Column(name="coin_name")
    private final String coin_name;
    @Column(name="coin_code")
    private final String coin_code;
    @Column(name="volume")
    private final double volume;
    @Column(name="usd_price")
    private final double usd_price;
    @Column(name="last_price")
    private final double last_price[];

    public Coin(String coin_name,String coin_code,double volume, double usd_price, double last_price[]){
        this.coin_name=coin_name;
        this.coin_code=coin_code;
        this.volume=volume;
        this.usd_price=usd_price;
        this.last_price=last_price;
    }

    public Integer getId() {
        return this.id;
    }

    public Portfolio getPortfolio() {
        return this.portfolio_coin;
    }

    public String getCoin_code() {
        return this.coin_code;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio_coin = portfolio;
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
