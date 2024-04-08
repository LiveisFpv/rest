package com.project.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.rest.models.Coin;
import com.project.rest.models.Deal;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "portfolio_coin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Coin> coins=new HashSet<>();
    @OneToMany(mappedBy = "portfolio",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Deal> deals=new HashSet<>();
    @Column(name = "profile_volume_usd")
    private final double[] profile_volume_usd;
    @Column(name = "profile_volume_btc")
    private final double[] profile_volume_btc;
    @Column(name = "current_volume_usd")
    private final double current_volume_usd;
    @Column(name = "current_volume_btc")
    private final double current_volume_btc;
    public Portfolio(Set<Coin> coins, Set<Deal> deals, double[] profile_volume_usd, double[] profile_volume_btc, double current_volume_usd, double current_volume_btc){
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

    public Set<Coin> getCoins() {
        return this.coins;
    }

    public Set<Deal> getDeals() {
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

    public void setid(Integer id) {
        this.id=id;
    }
}
