package com.project.rest.models;

import com.project.rest.models.Coin;
import com.project.rest.models.Deal;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "coins", cascade = CascadeType.ALL)
    private final Coin[] coins;
    @OneToMany(fetch=FetchType.LAZY,mappedBy = "deals", cascade = CascadeType.ALL)
    private final Deal[] deals;
    @Column(name = "profile_volume_usd")
    private final double[] profile_volume_usd;
    @Column(name = "profile_volume_btc")
    private final double[] profile_volume_btc;
    @Column(name = "current_volume_usd")
    private final double current_volume_usd;
    @Column(name = "current_volume_btc")
    private final double current_volume_btc;
    public Portfolio(Coin[] coins, Deal[] deals, double[] profile_volume_usd, double[] profile_volume_btc, double current_volume_usd, double current_volume_btc){
        this.coins=coins;
        this.deals=deals;
        this.profile_volume_usd=profile_volume_usd;
        this.profile_volume_btc=profile_volume_btc;
        this.current_volume_usd=current_volume_usd;
        this.current_volume_btc=current_volume_btc;
    }

    public Integer getId() {
        return this.id;
    }

    public Coin[] getCoins() {
        return this.coins;
    }

    public Deal[] getDeals() {
        return this.deals;
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
