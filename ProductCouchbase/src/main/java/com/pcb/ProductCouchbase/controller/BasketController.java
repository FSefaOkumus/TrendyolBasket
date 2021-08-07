package com.pcb.ProductCouchbase.controller;

import com.pcb.ProductCouchbase.model.Basket;
import com.pcb.ProductCouchbase.repo.BasketRepo;
import com.pcb.ProductCouchbase.service.BasketService;
import com.pcb.ProductCouchbase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/basket")
public class BasketController {

    @Autowired
    private BasketRepo basketRepo;

    private final BasketService basketService;

    private final ProductService productService;

    public BasketController(BasketService basketService, ProductService productService) {
        this.basketService = basketService;
        this.productService = productService;
    }

    @GetMapping
    public List<Basket> getAllBasket(){
        return basketRepo.findAll();
    }

    @GetMapping("/{id}")
    public Basket getBasketByID(@PathVariable Integer id){
        return basketService.findBasketById(id);
    }


//    @PostMapping("/add/{id}")
//    public Basket addProductToBasket(@RequestBody Product product){
//        basketService.
//        basketService.saveBasket(pr);
//    }

    @PostMapping
    public Basket saveBasket(@RequestBody Basket basket){
        return basketService.saveBasket(basket);
    }

//    @PostMapping("/{basketId}/add")
//    public Basket addProductToBasket(@RequestBody Product product, @PathVariable Integer basketId){
//        Basket basket = basketService.findBasketById(basketId);
//        basket.setItems(product);
//        return basketRepo.save(basket);
//    }

    @DeleteMapping
    public void deleteBasket(@RequestBody Basket basket){
        basketService.deleteBasket(basket);
    }


}
