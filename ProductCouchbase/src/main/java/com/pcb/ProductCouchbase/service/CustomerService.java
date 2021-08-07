package com.pcb.ProductCouchbase.service;


import com.pcb.ProductCouchbase.model.Basket;
import com.pcb.ProductCouchbase.model.BasketItems;
import com.pcb.ProductCouchbase.model.Customer;
import com.pcb.ProductCouchbase.model.Product;
import com.pcb.ProductCouchbase.repo.CustomerRepo;
import com.pcb.ProductCouchbase.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;

    public CustomerService(CustomerRepo customerRepo, ProductRepo productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }


    public List<Customer> findCustomers() {
        return customerRepo.findAll();
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer getCustomerById(String id) {
        return customerRepo.findById(id);
    }

//    public BasketItems addItemToCustomerBasket(String customerId, BasketItems item){
//        Customer customer = customerRepo.findById(customerId);
//        Long productId = item.getId();
//        Product product = productRepo.findById(productId);
//        item.setProduct(product);
//        customer.addItemToBasket(item);
//        return item;
//
//    }
    public BasketItems addItemToCustomerBasketv2(String customerId,Product product,BasketItems basketItems){
        Customer customer = customerRepo.findById(customerId);
        BasketItems temp = basketItems;
        temp.setProduct(product);
        customer.addItemToBasket(temp);
        return temp;
    }

    public Basket getCustomerBasket(String customerId){
        Customer customer = customerRepo.findById(customerId);
        return customer.getBasket();
    }

}
