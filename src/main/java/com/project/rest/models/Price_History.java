package com.project.rest.models;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
@Table(name="price_history")
public class Price_History {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "price")
    private Float price;
    @Column(name = "time")
    private String time;
    @Column(name = "status")
    private Boolean status;
    public Price_History(Float price, String time, Boolean status) {
        this.price = price;
        this.time = time;
        this.status = status;
    }
    public Float getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
