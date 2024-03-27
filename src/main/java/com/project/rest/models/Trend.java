package com.project.rest.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Trend")
public class Trend {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "coin_name")
    private final String coin_name;
    @Column(name = "coin_code")
    private final String coin_code;
    @Column(name = "h24")
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
