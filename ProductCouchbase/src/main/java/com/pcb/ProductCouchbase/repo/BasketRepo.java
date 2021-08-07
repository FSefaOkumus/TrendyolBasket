package com.pcb.ProductCouchbase.repo;

import com.pcb.ProductCouchbase.model.Basket;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepo extends CouchbaseRepository<Basket, Integer> {
}