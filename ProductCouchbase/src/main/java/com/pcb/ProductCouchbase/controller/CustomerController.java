package com.pcb.ProductCouchbase.controller;


import com.pcb.ProductCouchbase.model.Basket;
import com.pcb.ProductCouchbase.model.BasketItems;
import com.pcb.ProductCouchbase.model.Customer;
import com.pcb.ProductCouchbase.model.Product;
import com.pcb.ProductCouchbase.repo.CustomerRepo;
import com.pcb.ProductCouchbase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    private CustomerService customerService;

    public CustomerController(CustomerRepo customerRepo, CustomerService customerService) {
        this.customerRepo = customerRepo;
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable String customerId) {
        return (customerService.getCustomerById(customerId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @GetMapping("/{customerId}/cart")
    @ResponseStatus(HttpStatus.OK)
    public Basket getCustomerBasket(@PathVariable String customerId){
        return customerService.getCustomerBasket(customerId);
    }

    @PostMapping("/{customerId}/cart")
    public BasketItems addItemToBasket(@PathVariable String customerId,@RequestBody Product item,BasketItems basketItems){
        return customerService.addItemToCustomerBasketv2(customerId,item,basketItems);

    }

//    @PostMapping("/{customerId}/update/cart")
//    public

}