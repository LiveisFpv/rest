package com.project.rest.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@Table(name = "deal")
public class Deal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="deal_id")
    private Portfolio deals;
    @Column(name="date")
    private final String date;
    @Column(name="type")
    private final String type;
    @Column(name="price")
    private final double price;
    @Column(name="volume")
    private final double volume;
    @Column(name="coin_name")
    private final String coin_name;
    @Column(name="coin_code")
    private final String coin_code;
    public Deal(String date, String type, double price, double volume, String coin_name, String coin_code){
        this.date=date;
        this.type=type;
        this.price=price;
        this.volume=volume;
        this.coin_name=coin_name;
        this.coin_code=coin_code;
    }

    public Integer getId() {
        return this.id;
    }

    public Portfolio getDeals() {
        return this.deals;
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
