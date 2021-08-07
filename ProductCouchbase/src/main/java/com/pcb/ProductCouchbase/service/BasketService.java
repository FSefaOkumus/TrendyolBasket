package com.pcb.ProductCouchbase.service;


import com.pcb.ProductCouchbase.model.Basket;
import com.pcb.ProductCouchbase.model.BasketItems;
import com.pcb.ProductCouchbase.model.Customer;
import com.pcb.ProductCouchbase.model.Product;
import com.pcb.ProductCouchbase.repo.BasketRepo;
import com.pcb.ProductCouchbase.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepo basketRepo;

    public BasketService(BasketRepo basketRepo) {
        this.basketRepo = basketRepo;

    }

    public List<Basket> getAllBaskets(){
        return basketRepo.findAll();
    }

    public Optional<Basket> getBasket(Integer id){
        return basketRepo.findById(id);
    }

    public Basket saveBasket(Basket basket){
        basketRepo.save(basket);
        return basket;
    }


    public void deleteBasket(Basket basket){
        basketRepo.delete(basket);
    }

    public Basket findBasketById(Integer id){
        return basketRepo.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Basket not found with id %s", id)));
    }




}
