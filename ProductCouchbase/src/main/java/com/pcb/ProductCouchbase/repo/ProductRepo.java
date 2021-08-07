package com.pcb.ProductCouchbase.repo;

import com.pcb.ProductCouchbase.model.Product;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends CouchbaseRepository<Product, String> {

    Product findById(long id);
}
