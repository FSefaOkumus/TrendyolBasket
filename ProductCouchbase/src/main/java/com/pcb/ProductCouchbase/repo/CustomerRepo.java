package com.pcb.ProductCouchbase.repo;


import com.pcb.ProductCouchbase.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer, Integer> {
    Customer findById(String id);
}