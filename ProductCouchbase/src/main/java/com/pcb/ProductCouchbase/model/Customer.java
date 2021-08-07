
package com.pcb.ProductCouchbase.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Customer {

    @Id
    private String id;

    private String name;

    private String email;

    @Field
    private Basket basket;

    public Customer(String id, String name, String email, Basket basket) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.basket = basket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void addItemToBasket(BasketItems item){
        Basket.add(item);
    }

}