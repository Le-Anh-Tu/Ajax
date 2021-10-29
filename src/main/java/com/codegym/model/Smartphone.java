package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "smartphones")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producer;
    private String model;
    private String price;

    public Smartphone() {
    }

    public Smartphone(Long id, String producer, String model, String price) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }
}
