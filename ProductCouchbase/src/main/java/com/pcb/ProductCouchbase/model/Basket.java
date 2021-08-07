package com.pcb.ProductCouchbase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    @Id
    private long id;

    private Double totalItemCost;

    private Double totalBasketCost;


    private static Map<Long, BasketItems> items = new HashMap<>();

    public static void add(BasketItems item) {
        items.computeIfPresent(item.getId(), (id, shoppingCartItem) -> {
            shoppingCartItem.incrementQuantity();
            return shoppingCartItem;
        });
        items.putIfAbsent(item.getId(), item);
    }

    public void remove(long id) {
        if (!items.containsKey(id)) {
            throw new RuntimeException();
        }
        BasketItems itemToRemove = items.get(id);
        itemToRemove.decrementQuantity();

        if (itemToRemove.getQuantity() <= 0) {
            items.remove(itemToRemove.getId());
        }
    }

    public void removeAll(long id) {
        items.remove(id);
    }

    public double calculatePrice() {
        double price = 0.0;
        for (Map.Entry<Long, BasketItems> itemEntry : items.entrySet()) {
            BasketItems item = itemEntry.getValue();

            price += item.getCost();
        }

        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setItems(Map<Long, BasketItems> items) {
        this.items = items;
    }
//    public void addItem(Product product){
//
//        this.setItems();
//    }

    public void setTotalPrice(Double totalPrice) {
        this.totalItemCost = totalPrice;
    }

    public Double getBasketPrice() {
        double totalBasketCost= calculatePrice();
        double cargo= 0.0;

        if(totalBasketCost<100){
            cargo=4.99;
        }
        else{
            cargo=9.99;
        }
        totalBasketCost+=cargo;
        return totalBasketCost;
    }

    public Map<Long, BasketItems> getItems() {
        return items;
    }

    public long getId() {
        return id;
    }

}
