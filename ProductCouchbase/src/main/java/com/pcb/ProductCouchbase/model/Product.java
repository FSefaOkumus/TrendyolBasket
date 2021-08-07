package com.pcb.ProductCouchbase.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.stereotype.Service;
@Document
public class Product {

    @Id
    private String id;
    private String title;
    private Double price;
    private Integer stock;

    public Product(String id, String title, Double price, Integer stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }





}
